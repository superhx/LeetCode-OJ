import java.util.Stack;
import java.util.Arrays;

public class Solution {
    public int calculate(String s) {
        long rst = 0;
        long tail = 0;

        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            switch (s.charAt(i)){
                case '+': case '-': case '*': case '/':
                    operator = s.charAt(i);
                    break;
                default:
                    int start = i;
                    while(true) {
                        if (i == s.length() - 1) break;
                        char c = s.charAt(i + 1);
                        if (!(c >= '0' && c <= '9')) break;
                        i++;
                    }
                    int digit = Integer.parseInt(s.substring(start, i + 1));
                    switch (operator) {
                        case '+':
                            rst += digit;
                            tail = digit;
                            break;
                        case '-':
                            rst -= digit;
                            tail = -digit;
                            break;
                        case '*':
                            rst += tail * digit - tail;
                            tail = tail * digit;
                            break;
                        case '/':
                            rst += tail / digit - tail;
                            tail = tail / digit;
                            break;
                    }
                    break;
            }
        }
        return (int)rst;
    }
}
