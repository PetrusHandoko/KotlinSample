
package com.eurekaoptimus.sample

import kotlinx.coroutines.*
import kotlin.system.measureNanoTime

class PalindromeAsync {

    companion object {
        suspend fun find(input: String): String {
            //var maxPalindrome = ""
            val result = mutableListOf<Deferred<String>>()
            if ( input.isPalindrome()) return input
            runBlocking {
                for (i in 0..input.length - 2) {
                    var tail = i + 1
                    var foundOne = false //current.isPalindrome()
                    val pali = async (context = Dispatchers.Default ){
                        var localMaxPalindrome = ""
                        while (!foundOne && tail++ < input.length / 2 + 1) {
                            val current = input.substring(i, tail)
                            foundOne = current.isPalindrome()
                            if (foundOne && localMaxPalindrome.length <= current.length) {
                                localMaxPalindrome = current
                            }
                        }
                        localMaxPalindrome
                    }
                    result.add(pali)
                }
            }
            println(" Max: ${result.size}")

            return result.awaitAll().findLongestString()
        }
    }
}

fun List<String>.findLongestString(): String {
    return this.maxByOrNull { it.length } ?: ""
}
fun test(){

    println( "Test "+ "A".isPalindrome())
    "AA".isPalindrome()
    "ABA".isPalindrome()
    "ABBA".isPalindrome()
    //val res = Palindrome.find(input)

}

// DSL
suspend fun String.findMaxPalindrome(): String = PalindromeAsync.find(this)

fun String.isPalindrome() : Boolean  {
    if ( this.length <= 1 ) return false
    for ( i in 0..this.length/2 ){
        val end = this.length-i-1
        if ( this[i] != this[end]){
            return false
        }
    }
//    println("Palindrome found $this")
    return true
}


fun main (){
    runBlocking {
        val input = "ABACDCAEABACDCAEEWREABBAEWREABABACDCAEEWREABBABAABACABACDCAEEWREABBADCAEEWRABACDCAEEWREABBAEABBA"
        val duration = measureNanoTime {
            input.findMaxPalindrome()
        }
        println(" elapse:$duration")
        println("------------")//+input.findMaxPalindrome())
        println( "Input string $input is ${input.isPalindrome()} palindrome.\nMax palindrome found ${input.findMaxPalindrome()}")
        //println ("Palindrome: $res " + res.isPalindrome())
    }


}
