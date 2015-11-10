import java.util.Stack;

class EvaluateReversePolishNotation {
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
