public class l279 {

}


/**
 *
 * dp
 * 外层循环是n次
 * 如果这个数自己本身不是平方数则进入内层循环
 * 内层循环去找这个数所有可能的组合，如果38 = 1+37 = 2+36 = 3+35 ...
 * 这样的时间复杂度是O(n)
 *
 * 优化方案：
 * 内层循环只遍历到根号n，如 38 = 1+37 = 4+34 = 9+29
 * 时间复杂度 O(n^1.5)
 */
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                dp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= sqrt; j++) {
                    min = Math.min(min, 1 + dp[i - j * j]);
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}
