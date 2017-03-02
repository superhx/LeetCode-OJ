public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> rst = new LinkedList<>();

        int index = 0;
        while (index < words.length) {
            int count = words[index].length(), tail = index + 1;

            while (tail < words.length) {
                if (words[tail].length() + count + 1 > L) break;
                count += words[tail++].length() + 1;
            }

            StringBuilder str = new StringBuilder();
            if (tail == words.length || tail == index + 1) {
                for (int i = index; i < tail; i++) str.append(words[i]).append(" ");
                str.deleteCharAt(str.length() - 1);
                for (int i = str.length(); i < L; i++) str.append(" ");
            } else {
                count -= tail - index - 1;
                int space = (L - count) / (tail - index - 1);
                int remain = (L - count) % (tail - index - 1);

                for (int i = index; i < tail; i++) {
                    str.append(words[i]);
                    if (i == tail - 1) break;
                    for (int j = 0; j < space + (i - index < remain ? 1: 0); j++) str.append(" ");
                }
            }
            rst.add(str.toString());
            index = tail;
        }
        return rst;
    }
}
