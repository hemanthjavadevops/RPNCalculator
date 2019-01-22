package com.rpn.calculator;

import com.rpn.exceptions.InsufficientParametersException;
import com.rpn.operations.mathematic.*;
import com.rpn.operations.nonmathematic.ClearOperation;
import com.rpn.operations.nonmathematic.UndoOperation;

public enum Operation implements Operator
{
    ADD("+", new AddOperation()),
    SUBTRACT("-", new SubtractOperation()),
    MULTIPLY("*", new MultiplyOperation()),
    DIVIDE("/", new DivideOperation()),
    SQRT("sqrt", new SqrtOperation()),
    UNDO("undo", new UndoOperation()),
    CLEAR("clear", new ClearOperation()),
	POW("pow",new PowerOperation());

    private final CalculatorOperation calculatorOperationValue;
    private final String operatorValue;

    Operation(String operator, CalculatorOperation calculatorOperation)
    {
    	operatorValue = operator;
    	calculatorOperationValue = calculatorOperation;
    }

    public void perform(RPNCalculator calculator) throws InsufficientParametersException
    {
    	calculatorOperationValue.perform(calculator);
    }

    public String getOperator()
    {
        return operatorValue;
    }

    @Override
    public boolean isOperator()
    {
        return true;
    }

    @Override
    public String toString() {
        return getOperator();
    }
}
