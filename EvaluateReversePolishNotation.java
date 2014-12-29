/*
*Evaluate the value of an arithmetic expression in Reverse Polish Notation.
*
*Valid operators are +, -, *, /. Each operand may be an integer or another expression.
*
*Some examples:
*  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
*  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int prev;
		int next;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			try {
				stack.push(Integer.parseInt(tokens[i]));
			} catch (Exception ex) {
				next = stack.pop();
				prev = stack.pop();
				switch (tokens[i]) {
				case "+":
					prev = prev + next;
					break;
				case "-":
					prev = prev - next;
					break;
				case "*":
					prev = prev * next;
					break;
				case "/":
					prev = prev / next;
					break;
				}
				stack.push(prev);
			}
		}
		return stack.pop();
    }
}