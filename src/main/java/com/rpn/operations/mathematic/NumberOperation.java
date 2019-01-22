package com.rpn.operations.mathematic;

import com.rpn.calculator.Operator;
import com.rpn.calculator.CalculatorOperation;
import com.rpn.calculator.InputNumber;
import com.rpn.calculator.RPNCalculator;
import com.rpn.exceptions.InsufficientParametersException;

import java.util.EmptyStackException;

abstract class NumberOperation implements CalculatorOperation
{
    InputNumber popInputNumber(RPNCalculator calculator) throws InsufficientParametersException
    {
        try {
            Operator input = calculator.pop();
            return (InputNumber) input;
        }
        catch (EmptyStackException exception) {
            throw new InsufficientParametersException();
        }
    }
}
