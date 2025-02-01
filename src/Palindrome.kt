class Palindrome {

    companion object {
        fun find(input: String): String {
            if ( input.isPalindrome()) return input
            var maxPalindrome = ""
            for (i in 0..input.length-2) {
                var tail = i+1
                var foundOne = false //current.isPalindrome()
                while (!foundOne && tail++ < input.length/2 + 1) {
                    val current = input.substring(i, tail)
                    foundOne = current.isPalindrome()
                    if (foundOne && maxPalindrome.length <= current.length){
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

    println( "Test "+ "A".isPalindrome())
    "AA".isPalindrome()
    "ABA".isPalindrome()
    "ABBA".isPalindrome()
    val res = Palindrome.find(input)
    println("------------")
    println( "Input string $input is palindrome? ${input.isPalindrome()}.\nMax palindrome found $res")
    //println ("Palindrome: $res " + res.isPalindrome())
}

fun String.isPalindrome() : Boolean  {
    if ( this.length <= 1 ) return false
    for ( i in 0..this.length/2 ){
        val end = this.length-i-1
        if ( this[i] != this[end]){
            return false
        }
    }
    println("Palindrome found $this")
    return true
}