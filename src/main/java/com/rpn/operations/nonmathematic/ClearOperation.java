package com.rpn.operations.nonmathematic;

import com.rpn.calculator.CalculatorOperation;
import com.rpn.calculator.RPNCalculator;

public class ClearOperation implements CalculatorOperation
{
    @Override
    public void perform(RPNCalculator calculator)
    {
        calculator.clear();
    }
}
