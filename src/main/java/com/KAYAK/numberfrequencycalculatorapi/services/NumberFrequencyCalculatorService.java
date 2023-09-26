package com.KAYAK.numberfrequencycalculatorapi.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class NumberFrequencyCalculatorService {

    public void calculateNumberFrequency(List<Integer> inputNumbers) {
        List<Integer> inputNumbersRange = getRangeFromInputMinMaxValues(inputNumbers);
        List<Integer> inputNumbersFrequency =
                getElementFrequencyFromTargetList(inputNumbersRange, inputNumbers);
        printElementsWithFrequencies(inputNumbersRange, inputNumbersFrequency);
    }

    public static List<Integer> getRangeFromInputMinMaxValues(List<Integer> input) {
        List<Integer> outputList = new ArrayList<>();
        for (Integer i = Collections.min(input); i <= Collections.max(input); i++) {
            outputList.add(i);
        }
        return outputList;
    }

    public static List<Integer> getElementFrequencyFromTargetList(
            List<Integer> elementsToGetFrequencyOf,
            List<Integer> elementsToSearch
    ) {
        List<Integer> elementFrequencies = new ArrayList<>();
        for (Integer i : elementsToGetFrequencyOf) {
            Integer elementFrequency = 0;
            for (Integer toSearch : elementsToSearch) {
                if (toSearch.equals(i)) {
                    elementFrequency++;
                }
            }
            elementFrequencies.add(elementFrequency);
        }
        return elementFrequencies;
    }

    public static void printElementsWithFrequencies(
            List<Integer> elements,
            List<Integer> elementFrequency
    ) {
        // calculating the number of spaces needed for a number
        // so that the output is readable with multiple digit numbers
        List<String> elementSpaces = new ArrayList<>();
        for (Integer element : elements) {
            StringBuilder space = new StringBuilder();
            for (int i = 0; i < String.valueOf(element).length(); i++) {
                space.append(" ");
            }
            elementSpaces.add(space.toString());
        }

        for (int i = Collections.max(elementFrequency); i > 0; i--) {
            for (int index = 0; index < elements.size(); index++) {
                if (elementFrequency.get(index) >= i) {
                    System.out.print("*" + elementSpaces.get(index));
                } else {
                    System.out.print(" "  + elementSpaces.get(index));
                }
            }
            System.out.println();
        }
        for (Integer element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
