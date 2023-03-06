package org.powermilk

const val PUNCT_REGEX_STRING = "[\\p{Punct}\\s]"

/**
 * Function extension for reverse words lettering (reverse word without changing order).
 */
fun String.reverseLettering() = splitWithWS().map { it.reversed() }.joinToString(separator = " ") { it }.punctTrim(true)

/**
 * Function extension for reverse words order.
 */
fun String.reverseWordsOrder() = splitWithWS().reversed().joinToString(separator = " ") { it }.punctTrim(false)

/**
 * Function for splitting string by whitespaces.
 */
private fun String.splitWithWS() = replace(PUNCT_REGEX_STRING.toRegex(), " $0").split("\\s+".toRegex())

private fun String.punctTrim(trimBegin: Boolean) =
    replace((if (trimBegin) " $PUNCT_REGEX_STRING" else "$PUNCT_REGEX_STRING ").toRegex()) { it.value.trim() }
