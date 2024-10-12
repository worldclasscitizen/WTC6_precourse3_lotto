package lotto.util;

public class InputValidator {
    public static void validateMoneyInput(String userInput) {
        isNumeric(userInput);
        validateDivisibleByThousand(userInput);
    }

    public static void validateLottoInput(String userInput) {
        String[] values = userInput.split(",");
        for (String value : values) {
            isNumeric(value.trim());
            isInRange(value.trim());
            // TODO : 중복은 아닌지
        }
    }

    public static void isNumeric(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    public static void validateInput(String userInput) {
        String[] values = userInput.split(",");
        for (String value : values) {
            InputValidator.isNumeric(value.trim());
        }
    }

    private static void validateDivisibleByThousand(String str) {
        int number = Integer.parseInt(str);
        if(number % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_UNIT);
        }
    }

    private static void isInRange(String str) {
        int number = Integer.parseInt(str);
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE);
        }
    }

    private static void isNotDuplicate(String str) {
        // TODO
    }
}