package vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValueTest {
    private Value value;
    
    @Test
    @DisplayName("Value의 값이 정수가 아닌경우 IllegalArgumentException 예외처리를 발생함.")
    void validateValue()
    {
        //give
        double input = 0.1;


        //then
        assertThatThrownBy(() -> new Value(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 받은 좌표가 정수가 아닙니다.");
    }
}
        