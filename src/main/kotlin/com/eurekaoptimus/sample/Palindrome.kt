package com.eurekaoptimus.sample

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

class Palindrome {

    companion object {

        fun find(input: String): String {

            if (input.isEmpty()) return ""
            var longest = input.substring(0, 1)
            val duration = measureNanoTime {
                for (i in 0..< input.length) {
                    input.expand_around_center(i){ left, right ->
                        if (right-left >= longest.length) {
                            longest = input.substring(left, right+1).trim()
                           // println("1 $longest")
                        }
                    }
                    input.expand_around_center(i,i+1){ left, right ->
                        if (right-left >= longest.length) {
                            longest = input.substring(left, right+1).trim()
                          //  println("2 $longest")
                        }
                    }
                }
            }
            println(" Duration ${(duration/1000).toFloat()}")
            return longest
        }

    }
}

fun main (){

    var res: String
    run {
        val input = "ABACDCAEABACDCAEEWRFAaaaaacfffcaaaaaBACDCAEABACDCAEEWRFGFHHJKEABBABACDCAFDSFHJJMEABACDCAEEWREABBAEWREABABACDCAEEWREABBABAABACABACDCAEEWREABBADCAEEWRABACDCAEEWREABBAEABBAAEWREABABACDCAEEWREABBABAABACABACDCAEEWREABBADCAEEWRABACDCAEEWREABBAEABBAGFHHJKEABBABACDCAFDSFHJJMEABACDCAEEWREABBAEWREABABACDCAEEWREABBABAABACABACDCAEEWREABBADCAEEWRABACDCAEEWREAHHHHHHHHHHHHHHHHBBAEABBAAEWREABABACDCAEEWREABBABAABACABACDCAEEWREABBADCAEEWRABACDCAEEWREABBAEABBA"
        val duration = measureTimeMillis {
            res = Palindrome.find(input)
        }
        println("Palindrome with $input, length ${input.length} $res elapse:$duration")
    }
    run {
        val input = "ABCBA"
        val duration = measureTimeMillis {
            res = Palindrome.find(input)
        }
        println("Palindrome with $input, length ${input.length} $res elapse:$duration")
    }
    run {
        val input = "ABBA"
        val duration = measureTimeMillis {
            res = Palindrome.find(input)
        }
        println("Palindrome with $input, length ${input.length} $res elapse:$duration")
    }
    run {
        val input = "TABBA"
        val duration = measureTimeMillis {
            res = Palindrome.find(input)
        }
        println("Palindrome with $input, length ${input.length} $res elapse:$duration")
    }
    run {
        val input = "ABBAT"
        val duration = measureTimeMillis {
            res = Palindrome.find(input)
        }
        println("Palindrome with $input, length ${input.length} $res elapse:$duration")
    }
}
