public class l91 {
}


/**
 *
 * 代码写的有点乱，dp思路其实比较简单
 *
 * 第i个状态为能组成多少种方式，记录为dp状态数组
 * 转移方程应该是 dp[i-1]+dp[i-2]，但是要注意0的处理！！
 *
 * 处理0特别麻烦，如果第i个数为0，则不需要加dp[i-1]，因为0不可以自己单独成为一个转码
 * 如果第i-1个数为0，则不需要加dp[i-2]，因为0i不可能成为转码，
 * ...
 */
class Solution {
    public int numDecodings(String s) {
        int m = s.length();
        if (m == 1) {
            if (s.charAt(0) == '0') {
                return 0;
            } else {
                return 1;
            }
        }
        int[] dp = new int[m];


        if (s.charAt(0) == '0'){
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i < m; i++) {
            int var1 = 0;
            if (s.charAt(i) != '0') {
                var1 = dp[i - 1];

            } else {
                var1 = 0;

            }

            int var2 = 0;
            if (s.charAt(i - 1) == '0') {
                var2 = 0;
            } else {
                int sum = (s.charAt(i) - '0') + (s.charAt(i - 1) - '0') * 10;
                if (sum >= 1 && sum <= 26) {
                    if (i - 2 < 0) {
                        var2 = 1;
                    } else {
                        var2 = dp[i - 2];
                    }
                } else {
                    var2 = 0;
                }
            }
            dp[i] = var1 + var2;
        }
        return dp[m - 1];
    }
}
