import org.junit.Test;

import static java.lang.Double.*;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void calculateBi() {
        Calculator calc = new Calculator();
        calc.reset();

        //Normal Test Case

        //Test Case 1 => 3.5 + 8.4 = 11.9
        calc.calculateBi(Calculator.BiOperatorModes.ADD, 3.5);
        assertEquals(calc.calculateBi(Calculator.BiOperatorModes.ADD, 8.4), (Double) 11.9);
        calc.reset();

        //Test Case 2 => 2.54 - 1.237 = 1.303
        calc.calculateBi(Calculator.BiOperatorModes.MINUS, 2.54);
        assertEquals(calc.calculateBi(Calculator.BiOperatorModes.MINUS, 1.237), (Double) 1.303);
        calc.reset();

        //Test Case 3 => 5 * 4.8 = 24
        calc.calculateBi(Calculator.BiOperatorModes.MULTIPLY, 5.0);
        assertEquals(calc.calculateBi(Calculator.BiOperatorModes.MULTIPLY, 4.8), (Double) 24.0);
        calc.reset();

        //Test Case 4 => 31 / -5 = -6.2
        calc.calculateBi(Calculator.BiOperatorModes.DIVIDE, 31.0);
        Double number2 = -6.2;
        assertEquals(calc.calculateBi(Calculator.BiOperatorModes.DIVIDE, -5.0), number2);
        calc.reset();

        //Test Case 5 => -2.5 ^ 3 = -15.625
        calc.calculateBi(Calculator.BiOperatorModes.XPOWEROFY, -2.5);
        number2 = -15.625;
        assertEquals(calc.calculateBi(Calculator.BiOperatorModes.XPOWEROFY, 3.0), number2);
        calc.reset();

        //Special Case

        //Test Case 1 => 5 / 0 = positive infinity
        calc.calculateBi(Calculator.BiOperatorModes.DIVIDE, 5.0);
        assertEquals(calc.calculateBi(Calculator.BiOperatorModes.DIVIDE, 0.0), (Double) POSITIVE_INFINITY);
        calc.reset();

        //Test Case 2 => -8 / 0 = negative infinity
        calc.calculateBi(Calculator.BiOperatorModes.DIVIDE, -8.0);
        assertEquals(calc.calculateBi(Calculator.BiOperatorModes.DIVIDE, 0.0), (Double) NEGATIVE_INFINITY);
        calc.reset();

        //Test Case 3 => 0 / 0 = NaN
        calc.calculateBi(Calculator.BiOperatorModes.DIVIDE, 0.0);
        assertEquals(calc.calculateBi(Calculator.BiOperatorModes.DIVIDE, 0.0), (Double) NaN);
        calc.reset();
    }

    @Test
    public void calculateMono() {
        Calculator calc = new Calculator();
        calc.reset();

        //Normal Test Case

        //Test Case 1 => 1.6 ^ 2 = 2.16
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.SQUARE, 1.6),  2.56, 0.00000001);
        calc.reset();

        //Test Case 2 => root(2) = √2
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.SQUAREROOT, 2.0), (Double) Math.sqrt(2));
        calc.reset();

        //Test Case 3 => inverse number of 0.8 = 1.25
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.ONEDEVIDEDBY, 0.8), (Double) 1.25);
        calc.reset();

        //Test Case 4 => cos(2pi) = 1
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.COS, 2*Math.PI), (Double) 1.0);
        calc.reset();

        //Test Case 5 => sin(-pi/2) = -1
        Double number2 = -1.0;
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.SIN, -Math.PI/2), number2);
        calc.reset();

        //Test Case 6 => tan(2pi) = 0
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.TAN, 360.0), (Double) 0.0);
        calc.reset();

        //Test Case 7 => tan(-pi/2) = NaN
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.TAN, -90.0), (Double) NaN);
        calc.reset();

        //Test Case 8 => tan(pi/3) = root(3)
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.TAN, Math.PI/3), Math.sqrt(3), 0.000001);
        calc.reset();

        //Test Case 9 => log10(100000) = 5
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.LOG, 100000.0), (Double) 5.0);
        calc.reset();

        //Test Case 10 => 2.4/100 = 0.024
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.RATE, 2.4), (Double) 0.024);
        calc.reset();

        //Test Case 11 => |-7| = 7
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.ABS, -7.0), (Double) 7.0);
        calc.reset();

        //Special Case

        //Test Case 1 => root(-2) = NaN
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.SQUAREROOT, -2.0), (Double) NaN);
        calc.reset();

        //Test Case 2 => inverse number of 0 = NaN
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.ONEDEVIDEDBY, 0.0), (Double) POSITIVE_INFINITY);
        calc.reset();

        //Test Case 3 => log10(0) = NaN
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.LOG, 0.0), (Double) NEGATIVE_INFINITY);
        calc.reset();

        //Test Case 4 => log10(-10) = NaN
        assertEquals(calc.calculateMono(Calculator.MonoOperatorModes.LOG, -10.0), (Double) NaN);
        calc.reset();

    }
}