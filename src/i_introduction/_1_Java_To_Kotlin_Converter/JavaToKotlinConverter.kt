package i_introduction._1_Java_To_Kotlin_Converter

import util.TODO

fun todoTask1(collection: Collection<Int>): String {
    var s: String = "{"
    for (item in collection) {
        s += "$item, "
    }
    s = s.substring(0, s.length - 2)
    s += "}"
    return s
}


fun task1(collection: Collection<Int>): String {
    return todoTask1(collection)
}
