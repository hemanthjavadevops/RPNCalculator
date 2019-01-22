package com.rpn.calculator;

import static org.junit.Assert.assertEquals;

import com.rpn.calculator.InputNumber;
import com.rpn.calculator.InputTransformer;
import com.rpn.exceptions.InvalidInputException;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class InputParserTest
{
    private final InputTransformer inputParser = new InputTransformer();

    @Test
    public void parseNumber()
    {
        assertEquals(
                inputParser.parseNumber("7"),
                Optional.of(new InputNumber("7"))
        );
    }

    @Test
    public void failToParseNumber()
    {
        assertEquals(
                inputParser.parseNumber("as"),
                Optional.empty()
        );
    }

    @Test
    public void parseAddOperator()
    {
        assertEquals(
                inputParser.parseOperator("+"),
                Optional.of(Operation.ADD)
        );
    }

    @Test
    public void parseSubtractOperator()
    {
        assertEquals(
                inputParser.parseOperator("-"),
                Optional.of(Operation.SUBTRACT)
        );
    }

    @Test
    public void parseMultiplyOperator()
    {
        assertEquals(
                inputParser.parseOperator("*"),
                Optional.of(Operation.MULTIPLY)
        );
    }

    @Test
    public void parseDivideOperator()
    {
        assertEquals(
                inputParser.parseOperator("/"),
                Optional.of(Operation.DIVIDE)
        );
    }

    @Test
    public void parseClearOperator()
    {
        assertEquals(
                inputParser.parseOperator("clear"),
                Optional.of(Operation.CLEAR)
        );
    }

    @Test
    public void parseUndoOperator()
    {
        assertEquals(
                inputParser.parseOperator("undo"),
                Optional.of(Operation.UNDO)
        );
    }

    @Test
    public void parseSqrtOperator()
    {
        assertEquals(
                inputParser.parseOperator("sqrt"),
                Optional.of(Operation.SQRT)
        );
    }

    @Test
    public void parsePowOperator()
    {
        assertEquals(
                inputParser.parseOperator("pow"),
                Optional.of(Operation.POW)
        );
    }

    @Test
    public void throwException()
    {
        try {
            inputParser.parseValue("a");
        }
        catch (InvalidInputException exception) {
            return;
        }

        Assert.fail("Eligible for InputParseException exception");
    }
}
