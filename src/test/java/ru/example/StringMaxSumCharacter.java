package ru.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringMaxSumCharacter {

    private static final String[] INPUT_ARRAY = {"aaaa", "bbbb", "cccc", "abab", "abcabc", "aaccaab", "aabaab"};
    private static final String[] INPUT_ARRAY1 = {"ac", "bb"};
    private static final String[] INPUT_ARRAY2 = {""};

    ru.example.helper.StringMaxSumCharacter stringMaxSumCharacter = new ru.example.helper.StringMaxSumCharacter();

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(INPUT_ARRAY, 1, new String[]{"aabaab"}),
                Arguments.of(INPUT_ARRAY1, 2, INPUT_ARRAY1),
                Arguments.of(INPUT_ARRAY2, 1, new String[]{""})
        );
    }

    @ParameterizedTest(name = "Проверка суммы букв в строках {0}")
    @MethodSource("dataProvider")
    public void shouldReturnMaxSumCharInWord(String[] inputMessage, int expectedRes, String...expectedMessage) {
        List<String> resultList = stringMaxSumCharacter.findMaxSumCharacterStr(inputMessage);

        assertThat(resultList)
                .hasSize(expectedRes)
                .containsExactly(expectedMessage);

        System.out.println("Строки с максимальной суммой цен и наименьшей длиной:");
        for (String result : resultList) {
            System.out.println(result);
        }
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка значения null")
    public void shouldWhenNullMessage() {
        assertThatThrownBy(() -> {
            stringMaxSumCharacter.findMaxSumCharacterStr(null);
        }).isInstanceOf(NullPointerException.class);
    }
}
