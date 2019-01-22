package com.rpn.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.rpn.exceptions.InvalidInputException;

public class RPNCalcMain
{
    public static void main(String[] args) throws IOException
	{
		RPNCalculator calculator = new RPNCalculator();
		Scanner scanner = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the expression to evaluate or 'exit' to quit");

		boolean continueEvaluation = true;
		while (continueEvaluation) {
			String inputExpression = br.readLine();
			if ("exit".equalsIgnoreCase(inputExpression)) {
				continueEvaluation = false;
			} else {
				try {
					calculator.evaluateInputExpression(inputExpression);
				} catch (InvalidInputException ex) {
					System.err.println(ex.getMessage());
					System.exit(1);
				}
				System.out.println("stack: " + calculator.result());
			}
		}
		scanner.close();
	}
}
