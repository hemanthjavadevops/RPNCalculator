package com.rpn.calculator;

import com.rpn.exceptions.InvalidInputException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;

public class InputTransformer
{
	/**
	 * 
	 * This method returns the operator in input expression
	 * 
	 * @param inputOperator
	 * @return
	 */
    Optional<Operation> parseOperator(String inputOperator)
    {
        return Arrays.stream(Operation.values())
                .filter(operator -> operator.getOperator().equalsIgnoreCase(inputOperator))
                .findAny();
    }

    /**
     * This method returns non-empty numeric value sent in input expression and empty
     * value for a operator.
     * 
     * @param number
     * @return
     */
    Optional<InputNumber> parseNumber(String number)
    {
        try {
            return Optional.of(new InputNumber(number));
        }
        catch (NumberFormatException numberFormatException) {
            return Optional.empty();
        }
    }

    /**
     * 
     * This method parses the individual token.Based on a whether the token is 
     * number or operator, parseNumber or parseOperator method is called 
     * 
     * @param individualTokenfromInput
     * @return
     * @throws InvalidInputException
     */
    Operator parseValue(String individualTokenfromInput) throws InvalidInputException
    {
        Operator input = null;
        Optional<InputNumber> number = parseNumber(individualTokenfromInput);

        if (number.isPresent()) {
            input = number.get();
        }
        else {
            Optional<Operation> operator = parseOperator(individualTokenfromInput);
            if (operator.isPresent()) {
                input = operator.get();
            } else {
                throw new InvalidInputException(individualTokenfromInput);
            }
        }

        return input;
    }

    /**
     * 
     * This method parses the input expression with delimiter of space.Based on number of tokens after
     * parsing, a loop is run to add the numbers/operations to LinkedList using respective conditions
     * 
     * @param inputExpression
     * @return
     * @throws InvalidInputException
     */
    public LinkedList<Operator> parse(String inputExpression) throws InvalidInputException
    {
        String[] inputs = inputExpression.split(" ");
        LinkedList<Operator> linkedList = new LinkedList<>();

        for (String input : inputs) {
            linkedList.add(parseValue(input.trim()));
        }

        return linkedList;
    }
}
