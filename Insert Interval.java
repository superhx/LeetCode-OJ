/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int s = newInterval.start, e = newInterval.end;
        List<Interval> left = new LinkedList<>(), right = new LinkedList<>();

        for (Interval i: intervals) {
            if (s > i.end) {
                left.add(i);
            } else if (e < i.start) {
                right.add(i);
            } else {
                s = Math.min(s, i.start);
                e = Math.max(e, i.end);
            }
        }
        left.add(new Interval(s, e));
        left.addAll(right);
        return left;
    }
}
