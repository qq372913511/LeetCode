public class l413 {
}


/**
 * 利用dp数组，记录以第i个位置结尾的等差数列的数量
 * 转移方程非常的巧妙，第i个位置的等差数列数量，如果第i个位置满足 [i]-[i-1] == [i-1] - [i-2] 的话，dp[i] = dp[i-1] + 1
 *
 * 举一反三：
 *  最长的连续子序列 此题的dp[i]实际记录的数+2就是以i结尾的最长连续子序列的长度
 */

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int[] dp = new int[A.length];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i-1] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum+= dp[i];
        }
        return sum;
    }
}