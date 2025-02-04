package com.eurekaoptimus.sample

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

class Palindrome {

    companion object {

        fun find(s: String): String {

            if (s.isEmpty()) return ""

            var longest = s.substring(0, 1)

            println("Palindrome with input length ${s.length}, \n  find   : I'm working in thread ${Thread.currentThread().name}")
            val duration = measureNanoTime {

                for (i in s.indices) {
                    // Check for odd-length palindromes
                    var left = i
                    var right = i
                    while (left >= 0 && right < s.length && s[left] == s[right]) { // && s[left] != ' ' && s[right] != ' '
                        if (right - left + 1 > longest.length) {
                            longest = s.substring(left, right + 1).trim()
                        }
                        left--
                        right++
                    }
//                    longest.trim()
                    // Check for even-length palindromes
                    left = i
                    right = i + 1
                    while (left >= 0 && right < s.length && s[left] == s[right]) {
                        if (right - left + 1 > longest.length) {
                            longest = s.substring(left, right + 1).trim()
                        }
                        left--
                        right++
                    }
                }
            }
            println("  Duration ${(duration/1000).toFloat()}")
            return longest
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
