class Palindrome {

    companion object {
        fun find(input: String): String {
            var maxPalindrome = ""
            for (i in 0..input.length-2) {
                var tail = i + 2
                var current = input.substring(i, tail)
                var notend = true
                while (notend && !current.isPalindrome()) {
                    if (tail < input.length/2+1) {
                        tail++
                        current = input.substring(i, tail)
                    } else {
                        notend = false
                    }
                }
                if (notend) {
                    // find palindrome
                    if (maxPalindrome.length < current.length) {
                        maxPalindrome = current
                    }
                }
            }
            return maxPalindrome
        }
    }
}

fun main (){
    val input = "ABACDCAEEWREABBA"
    println( "$input is "+ input.isPalindrome())

    println( "A "+ "A".isPalindrome())
    "AA".isPalindrome()
    "ABA".isPalindrome()
    "ABBA".isPalindrome()
    println ("P " + Palindrome.find(input))
}

fun String.isPalindrome() : Boolean  {
    println(this)
    if ( this.length==1) return false
    for ( i in 0..this.length/2 ){
        val end = this.length-i-1
        if ( this[i] != this[end]){
            return false
        }
    }
    println("Palindrome found $this")
    return true
}