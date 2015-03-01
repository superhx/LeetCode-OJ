package leetcode;


import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new LinkedList<List<Integer>>();
        int[] prevLine = new int[numRows];
        for (int i = 0; i < numRows; i++) {
            List<Integer> line = new LinkedList<Integer>();
            line.add(1);
            for (int j = 1; j < i + 1; j++) {
                line.add(prevLine[j - 1] + prevLine[j]);
            }
            triangle.add(line);

            int index = 0;
            for (Integer node : line) {
                prevLine[index++] = node;
            }
        }
        return triangle;
    }
}