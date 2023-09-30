

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return false;

        int[] leftMin = new int[n];
        leftMin[0] = nums[0];

        // Create an array to store the minimum value on the left of each element
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }

        TreeSet<Integer> rightCandidates = new TreeSet<>();

        // Traverse the nums array from right to left
        for (int j = n - 1; j >= 0; j--) {
            // Check if there exists a valid candidate for s3
            if (nums[j] > leftMin[j]) {
                Integer s3 = rightCandidates.lower(nums[j]);
                if (s3 != null && s3 > leftMin[j]) {
                    return true;
                }
            }
            rightCandidates.add(nums[j]);
        }

        return false;
    }
}

