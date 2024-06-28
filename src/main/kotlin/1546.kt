/**
 * №1546. Japanese Sorting
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1546
 *
 * Idea: to/do.
 *
 * This solution gets WA on the second test
 */
data class FileWOFirstNum(val prefix: String, val postfix: String) : Comparable<FileWOFirstNum> {
    override fun compareTo(other: FileWOFirstNum): Int {
        return if (prefix.compareTo(other.prefix) == 0)
            postfix.compareTo(other.postfix)
        else prefix.compareTo(other.prefix)
    }
}

fun main() {
    // input
    val files = mutableListOf<String>()
    while (true) files.add(readlnOrNull() ?: break)

    // solution
    // build similar prefixes
    val fileMap = mutableMapOf<FileWOFirstNum, MutableList<String>>()

    for (file in files) {
        val prefix = file.takeWhile { it.isLetter() }
        val number = file.removePrefix(prefix).takeWhile { it.isDigit() }
        val postfix = file.removePrefix(prefix).dropWhile { it.isDigit() }

        val strWoNum = FileWOFirstNum(prefix, postfix)

        fileMap[strWoNum] ?: fileMap.put(strWoNum, mutableListOf())
        fileMap[strWoNum]!!.add(number.ifEmpty { "-1" })
    }

    // japanese sort
    for (fileList in fileMap.values) {
        fileList.sortWith { o1, o2 ->
            val o1num = o1.toInt()
            val o2num = o2.toInt()
            if (o1num == o2num) return@sortWith o2.length.compareTo(o1.length)
            else return@sortWith o1num.compareTo(o2num)
        }
    }

    // build files
    files.clear()
    fileMap.toSortedMap().forEach { (file, numbers) ->
        numbers.forEach { number ->
            files.add(file.prefix.plus(if (number == "-1") "" else number).plus(file.postfix))
        }
    }

    // output
    println(files.joinToString("\n"))
}