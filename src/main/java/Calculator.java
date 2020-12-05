/**
 * @name        Simple Java Calculator
 * @file        Calculator.java
 * @author      SORIA Pierre-Henry
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 */

import static java.lang.Double.NaN;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class Calculator {

    public enum BiOperatorModes {
        /***
         * BiOperatorModes.
         */
        NORMAL, ADD, MINUS, MULTIPLY, DIVIDE, XPOWEROFY
    }

    public enum MonoOperatorModes {
        /***
         * MonoOperatorModes.
         */
        SQUARE, SQUAREROOT, ONEDEVIDEDBY, COS, SIN, TAN, LOG, RATE, ABS
    }

    private Double num1, num2;
    /***
     * private num1 num2.
     */
    private BiOperatorModes mode = BiOperatorModes.NORMAL;
    /***
     * BiOperatorModes mode.
     */

    private Double calculateBiImpl() {
        if (mode == BiOperatorModes.NORMAL) {
            return num2;
        }
        if (mode == BiOperatorModes.ADD) {
            if (num2 != 0) {
                return num1 + num2;
            }

            return num1;
        }
        if (mode == BiOperatorModes.MINUS) {
            return num1 - num2;
        }
        if (mode == BiOperatorModes.MULTIPLY) {
            return num1 * num2;
        }
        if (mode == BiOperatorModes.DIVIDE) {
            return num1 / num2;
        }
        if (mode == BiOperatorModes.XPOWEROFY) {
            return pow(num1, num2);
        }

        // never reach
        throw new Error();
    }

    public Double calculateBi(final BiOperatorModes newMode, final Double num) {
        if (mode == BiOperatorModes.NORMAL) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return NaN;
        } else {
            num2 = num;
            num1 = calculateBiImpl();
            mode = newMode;
            return num1;
        }
    }

    public Double calculateEqual(final Double num) {
        /***
         * calculateEqual.
         */
        return calculateBi(BiOperatorModes.NORMAL, num);
    }

    public Double reset() {
        /***
         * calculateEqual.
         */
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.NORMAL;

        return NaN;
    }

    public Double calculateMono(final MonoOperatorModes newMode,
                                final Double num) {
        /**
         *
         */
        if (newMode == MonoOperatorModes.SQUARE) {
            return num * num;
        }
        if (newMode == MonoOperatorModes.SQUAREROOT) {
            return Math.sqrt(num);
        }
        if (newMode == MonoOperatorModes.ONEDEVIDEDBY) {
            return 1 / num;
        }
        if (newMode == MonoOperatorModes.COS) {
            return Math.cos(num);
        }
        if (newMode == MonoOperatorModes.SIN) {
            return Math.sin(num);
        }

        final int MOMO = 90;

        if (newMode == MonoOperatorModes.TAN) {
            if (num == 0 || num % (MOMO * 2) == 0) {
                return 0.0;
            }
            if (num % MOMO == 0 && num % (MOMO * 2) != 0) {
                return NaN;
            }

            return Math.tan(num);
        }
        if (newMode == MonoOperatorModes.LOG) {
            return log10(num);
        }

        final int TTEN = 100;

        if (newMode == MonoOperatorModes.RATE) {
           return num / TTEN;
        }
        if (newMode == MonoOperatorModes.ABS) {
            return Math.abs(num);
        }

        // never reach
        throw new Error();
    }

}
