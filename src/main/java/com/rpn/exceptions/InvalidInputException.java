package com.rpn.exceptions;

public class InvalidInputException extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5117958495079437595L;

	public InvalidInputException(String input)
    {
        super("Unable to parse: " + input);
    }
}
