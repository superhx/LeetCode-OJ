public class Solution {
    public List<List<Integer>> combine(int n, int k) {
          List<List<Integer>> rst = new LinkedList<>();
          if (k > n) return rst;
          if (k == n) {
              List<Integer> subset = new LinkedList<>();
              for (int i = 1; i <= n; i++) subset.add(i);
              rst.add(subset);
              return rst;
          }
          if (k == 1) {
              for (int i = 1; i <= n; i++) {
                  List<Integer> subset = new LinkedList<>();
                  subset.add(i);
                  rst.add(subset);
              }
              return rst;
          }

          List<List<Integer>> include = combine(n - 1, k - 1);
          for (List<Integer> l: include) l.add(n);
          rst.addAll(include);

          List<List<Integer>> exclude = combine(n - 1, k);
          rst.addAll(exclude);

          return rst;
      }
}
