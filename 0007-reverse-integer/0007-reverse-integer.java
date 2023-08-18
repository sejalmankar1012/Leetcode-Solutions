class Solution {
    public int reverse(int x) {
        int INT_MAX = 2_147_483_647; // 2^31 - 1
        int INT_MIN = -2_147_483_648; // -2^31

        // Initialize the result and the sign of the number
        int result = 0;
        int sign = x >= 0 ? 1 : -1;
        x = Math.abs(x);

        // Reverse the digits of the number
        while (x != 0) {
            int digit = x % 10;
            // Check for overflow before adding the new digit
            if (result > (INT_MAX - digit) / 10) {
                return 0;
            }
            result = result * 10 + digit;
            x /= 10;
        }

        // Apply the original sign to the reversed result
        return result * sign;
    }
}
