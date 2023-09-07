class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int size = 1 << n; // Calculate the total number of codes.

        for (int i = 0; i < size; i++) {
            int grayCode = i ^ (i >> 1); // Generate the Gray code using bitwise operations.
            result.add(grayCode);
        }

        return result;
    }
}
