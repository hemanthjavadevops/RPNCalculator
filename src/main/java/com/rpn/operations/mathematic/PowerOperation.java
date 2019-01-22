package com.rpn.operations.mathematic;

import com.rpn.calculator.InputNumber;
import com.rpn.calculator.RPNCalculator;
import com.rpn.exceptions.InsufficientParametersException;

import java.math.BigDecimal;

public class PowerOperation extends NumberOperation
{
    @Override
    public void perform(RPNCalculator calculator) throws InsufficientParametersException
    {
        InputNumber inputNumber = popInputNumber(calculator);
        calculator.push(new InputNumber(new BigDecimal(Math.pow(inputNumber.doubleValue(),2))));
    }
}
