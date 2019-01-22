package com.rpn.exceptions;

public class InsufficientParametersException extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2415961710089733571L;

	public InsufficientParametersException(String message)
    {
        super(message);
    }

    public InsufficientParametersException() { }
}
