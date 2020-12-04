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
        NORMAL, ADD, Minus, Multiply, Divide, Xpowerofy
    }

    public enum MonoOperatorModes {
        Square, SquareRoot, OneDevidedBy, Cos, Sin, Tan, Log, Rate, Abs
    }

    private Double num1, num2;
    private BiOperatorModes mode = BiOperatorModes.NORMAL;

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
        if (mode == BiOperatorModes.Minus) {
            return num1 - num2;
        }
        if (mode == BiOperatorModes.Multiply) {
            return num1 * num2;
        }
        if (mode == BiOperatorModes.Divide) {
            return num1 / num2;
        }
        if (mode == BiOperatorModes.Xpowerofy) {
            return pow(num1, num2);
        }

        // never reach
        throw new Error();
    }

    public Double calculateBi(BiOperatorModes newMode, Double num) {
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

    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.NORMAL, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.NORMAL;

        return NaN;
    }

    public Double calculateMono(MonoOperatorModes newMode, Double num) {
        if (newMode == MonoOperatorModes.Square) {
            return num * num;
        }
        if (newMode == MonoOperatorModes.SquareRoot) {
            return Math.sqrt(num);
        }
        if (newMode == MonoOperatorModes.OneDevidedBy) {
            return 1 / num;
        }
        if (newMode == MonoOperatorModes.Cos) {
            return Math.cos(num);
        }
        if (newMode == MonoOperatorModes.Sin) {
            return Math.sin(num);
        }
        if (newMode == MonoOperatorModes.Tan) {
            if (num == 0 || num % 180 == 0) {
                return 0.0;
            }
            if (num % 90 == 0 && num % 180 != 0) {
                return NaN;
            }

            return Math.tan(num);
        }
        if (newMode == MonoOperatorModes.Log) {
            return log10(num);
        }
        if (newMode == MonoOperatorModes.Rate) {
           return num / 100;
        }
        if (newMode == MonoOperatorModes.Abs) {
            return Math.abs(num);
        }

        // never reach
        throw new Error();
    }

}
