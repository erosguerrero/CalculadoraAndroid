package es.ucm.fdi.calculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorUnitTest {
    private final Calculator calculadora = new Calculator();
    private static final double delta = 1e-15; //Correción para doubles en asserts, epsilon

    @Test
    public void addition_isCorrect() {
        assertEquals(4, calculadora.suma(2,2));
    }

    @Test
    public void addition2_isCorrect() {
        assertEquals(5.0, calculadora.suma(2.5,2.5), delta);
    }
}
