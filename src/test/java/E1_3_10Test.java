import codefun.exercise.E1_3_10;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class E1_3_10Test {
    @Test
    public void test1() {
        assertEquals(E1_3_10.infixToPostfix("( a + b ) * c"), "a b + c *");
        assertEquals(E1_3_10.infixToPostfix("d + ( a + b ) * c"), "d a b + c * +");
    }
}
