public class Solution {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 1; i < nums.length; i++) nums[i] = nums[i - 1] * (i + 1);

        int[] pos = new int[n];
        for (int i = n - 1; i > 0; i--) {
            pos[n - 1 - i] = (k - 1) / nums[i - 1];
            k %= nums[i - 1];
            k = k == 0 ? nums[i - 1]: k;
        }
        pos[n - 1] = 0;

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) list.add(i);

        StringBuilder builder = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = pos[i] + 1;
            Iterator<Integer> it = list.iterator();
            int move = 0;
            while(it.hasNext()) {
                int value = it.next();
                move++;
                if (index != move) continue;
                it.remove();
                builder.append(value);
                break;
            }
        }
        return builder.toString();
    }
}
