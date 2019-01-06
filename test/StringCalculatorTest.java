import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    @Test
    public void testAddEmptyShouldReturnZero() {
        StringCalculator underTest = new StringCalculator();
        int value = underTest.add("");
        assertEquals(0, value);
    }

    @Test
    public void testAddOneNumberShouldReturnItself() {
        StringCalculator underTest = new StringCalculator();
        int value = underTest.add("12");
        assertEquals(12, value);
    }

    @Test
    public void testAddTwoNumberShouldReturnCorrectSum() {
        StringCalculator underTest = new StringCalculator();
        int value = underTest.add("12,34");
        assertEquals(46, value);
    }

    @Test
    public void testAddTwoNumberWithWhitespaceShouldReturnCorrectSum() {
        StringCalculator underTest = new StringCalculator();
        int value = underTest.add("12, 34");
        assertEquals(46, value);
    }


}