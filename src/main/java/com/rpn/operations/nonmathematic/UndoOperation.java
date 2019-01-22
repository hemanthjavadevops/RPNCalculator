package com.rpn.operations.nonmathematic;

import com.rpn.calculator.CalculatorOperation;
import com.rpn.calculator.RPNCalculator;
import com.rpn.exceptions.InsufficientParametersException;

public class UndoOperation implements CalculatorOperation
{
    @Override
    public void perform(RPNCalculator calculator) throws InsufficientParametersException
    {
        calculator.undo();
    }
}
