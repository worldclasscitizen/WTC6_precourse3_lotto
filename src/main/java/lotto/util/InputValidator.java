package lotto.util;

public class InputValidator {
    public static boolean validateMoneyInput(String userInput) {
        if (isNumeric(userInput)) {
            return validateDivisibleByThousand(userInput);
        }
        return false;
    }

    public static void validateLottoInput(String userInput) {
        String[] values = userInput.split(",");
        for (String value : values) {
            isNumeric(value.trim());
            isInRange(value.trim());
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE);
            return false;
        }
    }

    public static void validateInput(String userInput) {
        String[] values = userInput.split(",");
        for (String value : values) {
            InputValidator.isNumeric(value.trim());
        }
    }

    public static boolean validateDivisibleByThousand(String str) {
        int number = Integer.parseInt(str);
        if (number % 1000 != 0) {
            System.out.println(ErrorMessage.INVALID_UNIT);
            return false;
        }
        return true;
    }

    private static void isInRange(String str) {
        int number = Integer.parseInt(str);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE);
        }
    }
}