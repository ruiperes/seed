package com.ruiperes.framework.core.extension

import android.util.Patterns
import java.util.regex.Pattern

fun String.Companion.empty() = ""

fun String?.or(orString: String): String = this ?: orString

fun String?.isValidColor(): Boolean {
    if (this == null)
        return false
    val hexPattern = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$"
    val pattern = Pattern.compile(hexPattern)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}


fun String.maskNumber(mask: String): String {
    try {
        var index = 0
        val masked = StringBuilder()
        for (element in mask) {
            val c = element
            if (c == '#') {
                masked.append(this[index])
                index++
            } else if (c == 'x' || c == 'X') {
                masked.append(c)
                index++
            } else {
                masked.append(c)
            }
        }
        return masked.toString()
    } catch (e: Exception) {
        return this
    }
}

fun String.isValidUrl(): Boolean =
    "(?i)^(?:(?:https?|ftp)://)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)(?:\\.(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)*(?:\\.(?:[a-z\\u00a1-\\uffff]{2,}))\\.?)(?::\\d{2,5})?(?:[/?#]\\S*)?$".toRegex().matches(
        this
    )

fun String.isEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}