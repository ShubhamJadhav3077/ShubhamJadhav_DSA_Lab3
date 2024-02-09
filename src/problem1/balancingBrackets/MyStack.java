package problem1.balancingBrackets;

import java.util.Stack;

public class MyStack {
	public boolean validateExpression(String expression) {
		// creating stack
		Stack<Character> stack = new Stack<>();
		for (char i : expression.toCharArray()) {
			if (i == '{' || i == '[' || i == '(') {
				stack.push(i);
				continue;
			}
			if (stack.isEmpty()) {
				return false;
			}
			char z;
			switch (i) {
			case '}':
				z = stack.pop();
				if (z == '(' || z == '[') {
					return false;
				}
				break;
			case ']':
				z = stack.pop();
				if (z == '(' || z == '{') {
					return false;
				}
				break;
			case ')':
				z = stack.pop();
				if (z == '{' || z == '[') {
					return false;
				}
				break;
			}
		}
		return (stack.isEmpty());

	}
}
