public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        if (height == 0) return false;
        int width = matrix[0].length;
        if (width == 0) return false;
        return binarySearch(matrix, target, 0, height * width);
    }

    private boolean binarySearch(int[][] matrix, int target, int start, int end) {
        if (start > end - 1) return false;
        int mid = (start + end) / 2;
        int midValue = matrix[mid / matrix[0].length][mid % matrix[0].length];
        if (midValue == target) return true;
        if (target < midValue) return binarySearch(matrix, target, start, mid);
        if (target > midValue) return binarySearch(matrix, target, mid + 1, end);
        return false;
    }
}
