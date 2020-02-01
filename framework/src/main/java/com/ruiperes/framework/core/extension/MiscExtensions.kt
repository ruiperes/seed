package com.ruiperes.framework.core.extension

fun Boolean?.isNullOrFalse(): Boolean {
    return this == null || this == false
}

fun Boolean?.ifNullAsFalse(): Boolean {
    return this ?: false
}

fun Map<String, String>.filterEmptyValues() = this.filter { it.value.isNotEmpty() }
fun HashMap<String, Any>.filterEmptyValues() = this.filter { !it.value.isNullOrEmpty() }

@Suppress("NOTHING_TO_INLINE")
inline fun <T : Enum<T>> T.toInt(): Int = this.ordinal

inline fun <reified T : Enum<T>> Int.toEnum(): T = enumValues<T>()[this]
