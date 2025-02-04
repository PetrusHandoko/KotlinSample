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
        fun longestPalindrome(s: String): String {
            if (s.isEmpty()) return ""

            var longest = s.substring(0, 1)

            for (i in s.indices) {
                // Check for odd-length palindromes
                var left = i
                var right = i
                while (left >= 0 && right < s.length && s[left] == s[right]) {
                    if (right - left + 1 > longest.length) {
                        longest = s.substring(left, right + 1)
                    }
                    left--
                    right++
                }

                // Check for even-length palindromes
                left = i
                right = i + 1
                while (left >= 0 && right < s.length && s[left] == s[right]) {
                    if (right - left + 1 > longest.length) {
                        longest = s.substring(left, right + 1)
                    }
                    left--
                    right++
                }
            }

            return longest
        }
        fun longestPalindromes(s: String): String {
            if (s.isEmpty()) return ""

            var longest = s.substring(0, 1)

            for (i in s.indices) {
                // Check for odd-length palindromes
                var left = i
                var right = if (s.length%2 == 0 ) i else i+1
                while (left >= 0 && right < s.length && s[left] == s[right]) {
                    if (right - left + 1 > longest.length) {
                        longest = s.substring(left, right + 1)
                    }
                    left--
                    right++
                }

                // Check for even-length palindromes
//                left = i
//                right = i + 1
//                while (left >= 0 && right < s.length && s[left] == s[right]) {
//                    if (right - left + 1 > longest.length) {
//                        longest = s.substring(left, right + 1)
//                    }
//                    left--
//                    right++
//                }
            }

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
