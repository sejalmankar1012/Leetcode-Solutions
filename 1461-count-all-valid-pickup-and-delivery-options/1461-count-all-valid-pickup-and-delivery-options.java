class Solution {
    private static final int MOD = 1000000007;
    
    public int countOrders(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            // Ways to arrange all pickups, 1*2*3*4*5*...*n
            ans = (ans * i) % MOD;
            // Ways to arrange all deliveries, 1*3*5*...*(2n-1)
            ans = (ans * (2 * i - 1)) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 2; // Example input
        int output = solution.countOrders(n);
        System.out.println("Output: " + output);
    }
}



