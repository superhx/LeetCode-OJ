import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int sign = 1;
        int rst = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                rst += sign * num;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(sign);
                stack.push(rst);
                rst = 0;
                sign = 1;
            } else if (c == ')') {
                rst = stack.pop() + stack.pop() * rst;
            }
        }
        return rst;
    }
}
