package lotto.util;

public class ErrorMessage {
    public static final String NEW_LINE = "\n";
    public static final String ERROR_PREFIX = "[ERROR]";
    public static final String NUMBER_FORMAT_ERROR_MESSAGE = ERROR_PREFIX + "입력값은 숫자여야 합니다." + NEW_LINE;
    public static final String INVALID_UNIT = ERROR_PREFIX + "1000원 단위로 입력해 주세요." + NEW_LINE;
    public static final String INVALID_NUMBER_RANGE = ERROR_PREFIX + "1~45 사이의 숫자여야 합니다." + NEW_LINE;
    public static final String INVALID_LIST_SIZE = ERROR_PREFIX + "뭔가 이상합니다. 두 개의 세트를 합쳤는데 담긴 숫자가 6개도 안 됩니다." + NEW_LINE;
}