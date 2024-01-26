package hash

import java.io.*

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    for (i in 0 until n) {
        val sounds = reader.readLine().split(" ")
        val others = hashSetOf<String>();
        while (true) {
            val sentence = reader.readLine()
            if (sentence.equals("what does the fox say?")) break
            others.add(sentence.split(" goes ")[1])
        }
        for (sound in sounds) {
            if (!others.contains(sound)) writer.write("${sound} ")
        }
        writer.newLine()
    }

    reader.close()
    writer.close()
}