
/**
 * 这道题典型的dp
 * 每一个位置 要么从上面来的要么从左边来的，然后每个位置的最小cost应该是min(from up, from left)
 * 状态转移方程 min(up + cost[i], left + cost[i])
 * 循环顺序的讲究，一行一行，从左到右，遍历
 *
 * 空间优化思路：
 *  遍历的时候只需要记录上一行的数，和左边一个的数就可以了 本来是mn的空间复杂度，现在只需要n + 1
 */

class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];


        //对左上角第一个单独处理
        dp[0][0] = grid[0][0];

        // 第一行单独处理
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 对第一列单独处理
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        //剩余的最后处理
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j]);
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}