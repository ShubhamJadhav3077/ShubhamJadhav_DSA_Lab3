package problem1.balancingBrackets;

import java.util.Scanner;

public class DriverApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Taking input from the user for expression
		System.out.println("Enter the expression: ");
		String expression = sc.next();
		// User should include only brackets in the expression
		for (char i : expression.toCharArray()) {
			if (i == '{' || i == '[' || i == '(' || i == ')' || i == ']' || i == '}') {
				continue;
			}
			System.out.println("Please enter the expression having only brackets");
			System.exit(0);
		}
		// creating object of class
		MyStack stackObject = new MyStack();

		if (expression.length() % 2 == 1) { // checking length of expression
			System.out.println("Expression is Incomplete");
		} else {
			if (stackObject.validateExpression(expression)) {
				System.out.println("Expression is valid");
			} else {
				System.out.println("Expression is Invalid");
			}
		}
		sc.close();
	}

}
