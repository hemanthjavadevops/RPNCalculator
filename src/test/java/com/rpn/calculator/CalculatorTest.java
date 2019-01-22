package com.rpn.calculator;

import com.rpn.calculator.RPNCalculator;
import com.rpn.exceptions.InvalidInputException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest
{
    @Test
    public void testCaseCompareValues() throws InvalidInputException
    {
        RPNCalculator calculator = new RPNCalculator();
        calculator.evaluateInputExpression("1 2 3 4 5");

        assertEquals("1 2 3 4 5", calculator.result());
    }

    @Test
    public void testCaseSqrtClearSqrt() throws InvalidInputException
    {
        RPNCalculator calculator = new RPNCalculator();
        calculator.evaluateInputExpression("4 sqrt");

        assertEquals("2", calculator.result());

        calculator.evaluateInputExpression("clear 25 sqrt");

        assertEquals("5", calculator.result());
        
        calculator.evaluateInputExpression("clear 4 pow");

        assertEquals("16", calculator.result());
    }

    @Test
    public void testCaseSubClear() throws InvalidInputException
    {
        RPNCalculator calculator = new RPNCalculator();
        calculator.evaluateInputExpression("7 2 -");

        assertEquals("5", calculator.result());

        calculator.evaluateInputExpression("7 -");

        assertEquals("-2", calculator.result());

        calculator.evaluateInputExpression("clear");

        assertEquals("", calculator.result());
    }

    @Test
    public void testCaseUndoMulMulUndo() throws InvalidInputException
    {
        RPNCalculator calculator = new RPNCalculator();
        calculator.evaluateInputExpression("4 3 2 1");

        assertEquals("4 3 2 1", calculator.result());

        calculator.evaluateInputExpression("undo undo *");

        assertEquals("12", calculator.result());

        calculator.evaluateInputExpression("6 *");

        assertEquals("72", calculator.result());

        calculator.evaluateInputExpression("undo");

        assertEquals("12 6", calculator.result());
    }

    @Test
    public void testCaseDivMulDiv() throws InvalidInputException
    {
        RPNCalculator calculator = new RPNCalculator();
        calculator.evaluateInputExpression("7 48 4 /");

        assertEquals("7 12", calculator.result());

        calculator.evaluateInputExpression("*");

        assertEquals("84", calculator.result());

        calculator.evaluateInputExpression("4 /");

        assertEquals("21", calculator.result());
    }

    @Test
    public void testCaseMulClearSub() throws InvalidInputException
    {
        RPNCalculator calculator = new RPNCalculator();
        calculator.evaluateInputExpression("5 6 7 8 9");

        assertEquals("5 6 7 8 9", calculator.result());

        calculator.evaluateInputExpression("*");

        assertEquals("5 6 7 72", calculator.result());

        calculator.evaluateInputExpression("clear 7 10 -");

        assertEquals("-3", calculator.result());
    }

    @Test
    public void testCaseMul() throws InvalidInputException
    {
        RPNCalculator calculator = new RPNCalculator();
        calculator.evaluateInputExpression("3 4 5 6 7");

        assertEquals("3 4 5 6 7", calculator.result());

        calculator.evaluateInputExpression("* * * *");

        assertEquals("2520", calculator.result());
    }

    @Test
    public void testCaseInsufficientParamtersException() throws InvalidInputException
    {
        RPNCalculator calculator = new RPNCalculator();
        calculator.evaluateInputExpression("1 2 3 * 5 + * * 6 5");

        assertEquals("operator * (position: 15): insufficient parameters\n11", calculator.result());
    }

    @Test
    public void testCaseInsufficientParameters() throws InvalidInputException
    {
        RPNCalculator calculator = new RPNCalculator();
        calculator.evaluateInputExpression("3 4 5 * 6");

        assertEquals("3 20 6", calculator.result());

        calculator.evaluateInputExpression("+ * - 6 5");

        assertEquals("operator - (position: 5): insufficient parameters\n78", calculator.result());
    }
}
