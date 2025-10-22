package rk.powermilk

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

    private fun reverseLetteringProvider() = listOf(
        Arguments.of("hello world", "olleh dlrow"),
        Arguments.of("hello\tworld", "olleh dlrow"),
        Arguments.of("hello     world", "olleh dlrow"),
        Arguments.of("My name is PowerMilk", "yM eman si kliMrewoP"),
        Arguments.of("My name   is PowerMilk", "yM eman si kliMrewoP"),
        Arguments.of("My name is\tPowerMilk", "yM eman si kliMrewoP"),
        Arguments.of("This is test for reverse words function", "sihT si tset rof esrever sdrow noitcnuf"),
        Arguments.of(
            "This              is\ttest for\nreverse\rwords \t\n\rfunction",
            "sihT si tset rof esrever sdrow noitcnuf"
        ),
        Arguments.of("Litwo! Ojczyzno moja! Ty jesteś jak zdrowie,", "owtiL! onzyzcjO ajom! yT śetsej kaj eiwordz,"),
        Arguments.of("", ""),
        Arguments.of("     ", ""),
        Arguments.of("!!!", "!!!"),
        Arguments.of("hello!", "olleh!"),
        Arguments.of("¡Hola! ¿Qué tal?", "aloH¡! éuQ¿ lat?"),
        Arguments.of("你好 世界", "好你 界世"),
        Arguments.of("   hello world   ", "olleh dlrow"),
        Arguments.of("hello\nworld", "olleh dlrow"),
        Arguments.of("PowerMilk", "kliMrewoP")
    )

    private fun reverseOrderProvider() = listOf(
        Arguments.of("hello world", "world hello"),
        Arguments.of("hello\tworld", "world hello"),
        Arguments.of("hello     world", "world hello"),
        Arguments.of("My name is PowerMilk", "PowerMilk is name My"),
        Arguments.of("My name   is PowerMilk", "PowerMilk is name My"),
        Arguments.of("My name is\tPowerMilk", "PowerMilk is name My"),
        Arguments.of("This is test for reverse words function", "function words reverse for test is This"),
        Arguments.of(
            "This              is\ttest for\nreverse\rwords \t\n\rfunction",
            "function words reverse for test is This"
        ),
        Arguments.of("Litwo! Ojczyzno moja! Ty jesteś jak zdrowie,", ",zdrowie jak jesteś Ty !moja Ojczyzno !Litwo"),
        Arguments.of("", ""),
        Arguments.of("     ", ""),
        Arguments.of("!!!", "!!!"),
        Arguments.of("hello!", "!hello"),
        Arguments.of("¡Hola! ¿Qué tal?", "?tal ¿Qué !¡Hola"),
        Arguments.of("你好 世界", "世界 你好"),
        Arguments.of("   hello world   ", "world hello"),
        Arguments.of("hello\nworld", "world hello"),
        Arguments.of("PowerMilk", "PowerMilk")
    )
}
