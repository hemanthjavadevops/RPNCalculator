package com.rpn.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InputNumber extends BigDecimal implements Operator
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7386787616330426949L;

	public InputNumber(String number)
    {
        super(number);
    }

    public InputNumber(BigDecimal bigDecimal)
    {
        super(bigDecimal.toString());
    }

    // This is overridden to be false as the input is a number
    @Override
    public boolean isOperator()
    {
        return false;
    }

    public String toString()
    {
        String string = super.toPlainString();

        if (scale() >= 1) {
            BigDecimal bigDecimal = new BigDecimal(string);
            string = bigDecimal.setScale(10, RoundingMode.DOWN).stripTrailingZeros().toPlainString();
        }

        return string;
    }
}
