/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FYFES
 */
public class CalcEngineTest {
    CalcEngine calculator;
    
    public CalcEngineTest() {
    }
    
    @Before
    public void setUp() {
        calculator = new CalcEngine();
    }

    /* A test method for the equals method that tests if 3 multidigit numbers, when all digits and
    the + operator have been entered correctly, are correctly added – the display value ends
    up with the correct result after the equals method is executed. (E.G. the keys
    32+123+12= are correctly hit in order and the display value variable is correctly set to 167) */
    @Test
    public void testEquals() {
        calculator.numberPressed(3);
        calculator.numberPressed(2);
        calculator.plus();
        calculator.numberPressed(1);
        calculator.numberPressed(2);
        calculator.numberPressed(3);
        calculator.plus();
        calculator.numberPressed(1);
        calculator.numberPressed(2);
        calculator.equals();
        assertEquals(167, calculator.getDisplayValue());
    }

    /* A test method for the applyOperator method that tests that this method returns the correct
    error message about a key sequence error when the minus sign is hit two times in a row.
    The first time the minus is hit it is in the correct sequence, but the second time is out of
    sequence. (E.G. the keys 42—are hit in order). Remember that the applyOperator
    method is a private method that gets called from other methods. */
    @Test
    public void testApplyOperator() {
        calculator.numberPressed(4);
        calculator.numberPressed(2);
        calculator.minus();
        assertEquals("A key sequence error has occurred.", calculator.minus());
    }
}
