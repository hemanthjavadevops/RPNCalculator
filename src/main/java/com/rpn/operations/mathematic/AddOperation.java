package com.rpn.operations.mathematic;

import com.rpn.calculator.InputNumber;

public class AddOperation extends ArithmeticOperation
{
    @Override
    public InputNumber calculate(InputNumber x, InputNumber y)
    {
        return new InputNumber(x.add(y));
    }
}
