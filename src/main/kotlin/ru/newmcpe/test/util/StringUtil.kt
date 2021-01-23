package ru.newmcpe.test.util

object StringUtil {
    val alphabet: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    fun getRandomString() : String = List(15) { alphabet.random() }.joinToString("")
}