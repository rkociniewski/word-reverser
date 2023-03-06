package org.powermilk

import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ReverseWordsTest {
    @ParameterizedTest
    @MethodSource("reverseLetteringProvider")
    fun `should reverse words lettering`(input: String, expected: String) =
        assertEquals(expected, input.reverseLettering())

    @ParameterizedTest
    @MethodSource("reverseOrderProvider")
    fun `should reverse words order`(input: String, expected: String) =
        assertEquals(expected, input.reverseWordsOrder())

    private val inputList = listOf(
        "hello world",
        "hello\tworld",
        "hello     world",
        "My name is PowerMilk",
        "My name   is PowerMilk",
        "My name is\tPowerMilk",
        "This is test for reverse words function",
        "This              is\ttest for\nreverse\rwords \t\n\rfunction",
        "Litwo! Ojczyzno moja! Ty jesteś jak zdrowie,"
    )

    private val reverseLetteringExpected = listOf(
        "olleh dlrow",
        "olleh dlrow",
        "olleh dlrow",
        "yM eman si kliMrewoP",
        "yM eman si kliMrewoP",
        "yM eman si kliMrewoP",
        "sihT si tset rof esrever sdrow noitcnuf",
        "sihT si tset rof esrever sdrow noitcnuf",
        "owtiL! onzyzcjO ajom! yT śetsej kaj eiwordz,"
    )

    private val reverseOrderExpected = listOf(
        "world hello",
        "world hello",
        "world hello",
        "PowerMilk is name My",
        "PowerMilk is name My",
        "PowerMilk is name My",
        "function words reverse for test is This",
        "function words reverse for test is This",
        ",zdrowie jak jesteś Ty !moja Ojczyzno !Litwo"
    )

    private fun reverseLetteringProvider() =
        inputList.zip(reverseLetteringExpected).map { Arguments.of(it.first, it.second) }

    private fun reverseOrderProvider() =
        inputList.zip(reverseOrderExpected).map { Arguments.of(it.first, it.second) }
}
