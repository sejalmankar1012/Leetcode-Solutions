class Solution {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        int[] count = new int[101]; // Assuming the range of integers is from 1 to 100

        for (int num : nums) {
            ans += count[num]++;
        }

        return ans;
    }
}
