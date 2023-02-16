package es.ucm.fdi.calculator;

import org.junit.Test;
import es.ucm.fdi.calculator.*;
import static org.junit.Assert.assertEquals;

public class CalculatorUnitTest {
    Calculator calculadora;

    CalculatorUnitTest(){
        calculadora = new Calculator();
    }
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2+2);
    }

    @Test
    public void addition2_isCorrect() {
        assertEquals(5.0, 2.5 + 2.5);
    }
}
