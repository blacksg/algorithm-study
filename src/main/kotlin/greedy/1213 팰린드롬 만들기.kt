package greedy

import java.io.*

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    fun finish(answer: String) {
        writer.write(answer)
        reader.close()
        writer.close()
    }

    val counts = IntArray(26)
    val name = reader.readLine()
    for (character in name) {
        counts[character - 'A']++
    }

    var oddCharacterCount = 0;
    for (count in counts) {
        if (count % 2 == 1) {
            oddCharacterCount++
            if (oddCharacterCount > 1) {
                finish("I'm Sorry Hansoo")
                return
            }
        }
    }

    val leftHalfBuilder = StringBuilder()
    for (code in 0 until 26) {
        val count = counts[code]
        val character = (code + 'A'.code).toChar()
        for (i in 0 until count / 2) {
            leftHalfBuilder.append(character)
        }
    }

    val rightHalfBuilder = StringBuilder(leftHalfBuilder).reverse()

    if (oddCharacterCount == 1) {
        for (code in 0 until 26) {
            if (counts[code] % 2 == 1) {
                leftHalfBuilder.append((code + 'A'.code).toChar())
            }
        }
    }

    val palindrome = leftHalfBuilder.append(rightHalfBuilder).toString()
    finish(palindrome)
}