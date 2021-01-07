import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class l139 {
}

/**
 * dp
 * 到i字母作为子字符串
 * 如果在word dict找得到对应的结尾单词，则判断i - word.length() 的dp状态是否为真，如果是则dp[i]为真
 * 所有单词遍历一次，如果没有找到，则为false。、
 * 时间复杂度为String的长度m * 单词数量n
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int m = s.length();

        boolean[] dp = new boolean[m];


        for (int i = 0; i < m; i++) {
            for (String w : wordDict) {
                if (s.startsWith(w, i - w.length() + 1)) {
                    int remain = i - w.length();
                    if (remain >= 0) {
                        if (dp[remain]) {
                            dp[i] = true;
                            break;
                        } else {
                            dp[i] = false;
                        }
                    } else {
                        dp[i] = true;
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return dp[m - 1];
    }
}
