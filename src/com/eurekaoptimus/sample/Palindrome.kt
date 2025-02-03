package com.eurekaoptimus.sample

import kotlin.system.measureTimeMillis

class Palindrome {

    companion object {
        fun find(input: String): String {
            if ( input.isPalindrome()) return input
            var maxPalindrome = ""
            for (i in 0..input.length) {
                var tail = i+1
                val maxLoop = if ( (input.length/2 + i + tail) < input.length) (input.length/2 + i + tail) else input.length
                while (tail++ < maxLoop ) {
                    val current = input.substring(i, tail)
                    if ((maxPalindrome.length <= current.length) && current.isPalindrome()) {
                        maxPalindrome = current
                    }
                }
            }
            return maxPalindrome
        }
    }
}

fun main (){

    var res: String
    val input = "ABACDCAEABACDCAEEWRFAaaaaacfffcaaaaaBACDCAEABACDCAEEWRFGFHHJKEABBABACDCAFDSFHJJMEABACDCAEEWREABBAEWREABABACDCAEEWREABBABAABACABACDCAEEWREABBADCAEEWRABACDCAEEWREABBAEABBAAEWREABABACDCAEEWREABBABAABACABACDCAEEWREABBADCAEEWRABACDCAEEWREABBAEABBAGFHHJKEABBABACDCAFDSFHJJMEABACDCAEEWREABBAEWREABABACDCAEEWREABBABAABACABACDCAEEWREABBADCAEEWRABACDCAEEWREAHHHHHHHHHHHHHHHHBBAEABBAAEWREABABACDCAEEWREABBABAABACABACDCAEEWREABBADCAEEWRABACDCAEEWREABBAEABBA"
    val duration = measureTimeMillis {
        res = Palindrome.find(input)
    }
    println("Palindrome with input length ${input.length} $res elapse:$duration")
}
