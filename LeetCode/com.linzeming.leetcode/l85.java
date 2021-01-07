public class l85 {
}


/**
 * 和最大正方形类似，不同的是要dp要记录两边的边长，其中横向方向边长来自于上面一格的信息，纵向方向的边长来自于左边一格的信息
 */

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][][] dp = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                } else if (i - 1 < 0 && j - 1 < 0) {
                    dp[i][j][0] = 1;
                    dp[i][j][1] = 1;
                } else if (i - 1 < 0 && j - 1 >= 0) {
                    dp[i][j][0] = 1;
                    dp[i][j][1] = dp[i][j - 1][1] + 1;
                } else if (i - 1 >= 0 && j - 1 < 0) {
                    dp[i][j][0] = dp[i - 1][j][0] + 1;
                    dp[i][j][1] = 1;
                } else {
                    dp[i][j][0] = dp[i - 1][j][0] + 1;
                    dp[i][j][1] = dp[i][j - 1][1] + 1;
                }
            }
        }

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dp[i][j][0] * dp[i][j][1]);
            }
        }
        return maxArea;
    }
}