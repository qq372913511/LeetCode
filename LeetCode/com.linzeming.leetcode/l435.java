import java.util.Arrays;
import java.util.Comparator;


/**
 * from HONGYANG
 * <p>
 * 这个思路为什么正确，换句话讲为什么按照end排序，而不是按照start排序？这个问题是比较困扰我的，因为我一开始就是按照start排序的。
 * <p>
 * 我的理解是这样：比如你一天要参加几个活动，这个活动开始的多早其实不重要，重要的是你结束的多早，早晨7点就开始了然后一搞搞一天，那你今天也就只能参加这一个活动；但如果这个活动开始的不早，比如9点才开始，但是随便搞搞10点就结束了，那你接下来就还有大半天的时间可以参加其他活动。
 * <p>
 * 这就是为啥要着眼于end，而不是start
 * <p>
 * <p>
 * 把区间按end升序排序之后，从左到右遍历每个区间，如果遇到重叠区间，选取end最小的区间保留，
 * 可以使得剩下的没有遍历到的区间[end, max]的长度最大，
 * 那么区间[end, max]也就更有可能容下更多的不重叠区间。
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int end = intervals[0][1];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
                continue;
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
}