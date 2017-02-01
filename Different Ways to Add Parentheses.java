import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> rst = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c) || c == ' ') continue;
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));
            for (int l: left) {
                for (int r: right) {
                    rst.add(calculate(l, r, c));
                }
            }
        }
        if (rst.size() == 0) {
            rst.add(Integer.valueOf(input));
        }
        return rst;
    }

    private static int calculate(int first, int second, char operator) {
        switch (operator) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
        }
        return 0;
    }
}
