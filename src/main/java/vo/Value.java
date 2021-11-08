package vo;

import java.util.regex.Pattern;

public class Value {
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);
    private int number;

    public Value(String number){
        if (!NUMBER_PATTERN.matcher(number).matches()) {
            throw new IllegalArgumentException("입력 받은 좌표가 정수가 아닙니다.");
        }
        this.number = Integer.parseInt(number);
    }

    public int value(){
        return number;
    }

}
