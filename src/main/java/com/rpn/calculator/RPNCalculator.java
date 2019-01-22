package com.rpn.calculator;

import com.rpn.exceptions.InvalidInputException;
import com.rpn.exceptions.InsufficientParametersException;

import java.util.LinkedList;
import java.util.Stack;

public class RPNCalculator
{
    private Stack<InputNumber> currentInputStack = new Stack<>();
    private LinkedList<Operator> inputHistory = new LinkedList<>();
    private InsufficientParametersException warning = null;

    public void evaluateInputExpression(String input) throws InvalidInputException
    {
        InputTransformer inputParser = new InputTransformer();
        int currentStackLength = inputHistory.size();

        try {
            pushAll(inputParser.parse(input));
        } catch (InsufficientParametersException exception)
        {
            int offset = 2 * (inputHistory.size() - currentStackLength) - 1;
            Operation operator = (Operation) inputHistory.getLast();

            warning = new InsufficientParametersException(
                    "operator " + operator.getOperator() + " (position: " + offset + "): insufficient parameters"
            );
        }
    }

    private void pushAll(LinkedList<Operator> calculatorInputs) throws InsufficientParametersException
    {
        for (Operator input : calculatorInputs) {
            inputHistory.add(input);
            push(input);
        }
    }

    public void push(Operator calculatorInput) throws InsufficientParametersException
    {
        if (calculatorInput.isOperator()) {
            Operation operator = (Operation) calculatorInput;
            operator.perform(this);
        }
        else {
            currentInputStack.push((InputNumber) calculatorInput);
        }
    }

    public Operator pop()
    {
        return currentInputStack.pop();
    }

    public void clear()
    {
        currentInputStack = new Stack<>();
    }

    @SuppressWarnings("unchecked")
	public void undo() throws InsufficientParametersException
    {
        currentInputStack = new Stack<>();

        inputHistory.removeLast();
        inputHistory.removeLast();

        LinkedList<Operator> input = (LinkedList<Operator>)inputHistory.clone();
        inputHistory = new LinkedList<>();
        pushAll(input);
    }

    public String result()
    {
        String string = currentInputStack.toString()
                .replace("[", "")
                .replace("]", "")
                .replaceAll(",", "");

        if (warning != null) {
            string = warning.getMessage() + "\n" + string;
            warning = null;
        }

        return string;
    }
}
