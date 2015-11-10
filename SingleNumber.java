class SingleNumber {
    public int singleNumber(int[] A) {
        int res = 0;
        for (int a : A)
            res ^= a;
        return res;
    }
}
