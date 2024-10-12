package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<Integer> parseInputToList(String userInput) {
        InputValidator.validateInput(userInput);

        return convertToIntegerList(userInput);
    }

    public static int convertToInteger(String userInput) {
        return Integer.parseInt(userInput);
    }

    private static List<Integer> convertToIntegerList(String userInput) {
        String[] values = userInput.split(",");
        List<Integer> intList = new ArrayList<>();

        for (String value : values) {
            intList.add(Integer.parseInt(value.trim()));
        }

        return intList;
    }
}
