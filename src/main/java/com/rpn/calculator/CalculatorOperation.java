package com.rpn.calculator;

import com.rpn.exceptions.InsufficientParametersException;

public interface CalculatorOperation
{
    void perform(RPNCalculator calculator) throws InsufficientParametersException;
}
