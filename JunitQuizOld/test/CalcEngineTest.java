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

    @Test
    public void singleDigitPress() {
        calculator.numberPressed(5);
        assertEquals(5, calculator.getDisplayValue());
    }

    @Test
    public void multipleDigitPress() {
        calculator.numberPressed(5);
        calculator.numberPressed(6);
        calculator.numberPressed(7);
        assertEquals(567, calculator.getDisplayValue());
    }
    
    @Test
    public void secondOperator() {
        calculator.numberPressed(10);
        calculator.minus();
        calculator.numberPressed(5);
        calculator.plus();
        calculator.numberPressed(6);
        calculator.equals();
        assertEquals(11, calculator.getDisplayValue());
    }
}
