public class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder str = new StringBuilder();
        int min = Math.min(a.length(), b.length());

        int in = 0;
        for (int i = 0; i < min; i++) {
            int left = a.charAt(i) - '0', right = b.charAt(i) - '0';
            str.append((left + right + in) % 2);
            in = (left + right + in) / 2;
        }

        String remain = a.length() == min ? (b.length() == min ? null: b): a;
        if (remain != null) {
            for (int i = min; i < remain.length(); i++) {
                str.append((remain.charAt(i) - '0' + in) % 2);
                in = (remain.charAt(i) - '0' + in) / 2;
            }
        }
        if (in == 1) str.append(in);
        return str.reverse().toString();
    }
}
