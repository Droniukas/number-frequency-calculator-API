package com.KAYAK.numberfrequencycalculatorapi.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class NumberFrequencyCalculatorServiceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Autowired
    private NumberFrequencyCalculatorService underTest;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void itShouldPrintAndCalculateNumberFrequency() {
        List<Integer> input = Arrays.asList(1, 2, 2, 3);
        underTest.calculateNumberFrequency(input);

        String expected = """
                \s\s*  \s
                * * *\s
                1 2 3\s
                """;
        assertThat(outContent.toString().replaceAll("\\r\\n", "\n")).isEqualTo(expected);
    }
}