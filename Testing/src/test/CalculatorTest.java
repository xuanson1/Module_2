package test;


import file.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void testAdd() {
        int a = 3;
        int b = 4;
        int actual = a + b;

        int result = Calculator.add(a,b);
        Assertions.assertEquals(result,actual);
    }
    public void testAddWithNumberLess0() {
        int a = -3;
        int b = -9;

        int actual = a + b;
        int result = Calculator.add(a,b);
        Assertions.assertEquals(result,actual);
    }
}
