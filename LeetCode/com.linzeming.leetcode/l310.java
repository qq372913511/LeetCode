import java.util.*;

public class l310 {
}


/**
 * 显然要用广度优先搜索，获取最小的高度树
 *
 * 目前思路是超时的，需要剪枝
 */


class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] maxHeight = new int[n];


        LinkedList<List<Integer>> queue = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            ArrayList<Integer> var1 = new ArrayList<>(n);
            var1.add(i);
            queue.addLast(var1);
        }

        int ans = 0;
        while (queue.size() > 0) {
            ans += 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> path = queue.pollFirst();
                List<Integer> next = findNext(path, edges);
                if (next.size() == 0) {
                    int rootNode = path.get(0);
                    maxHeight[rootNode] = Math.max(maxHeight[rootNode], path.size());
                } else {
                    for (int j = 0; j < next.size(); j++) {
                        ArrayList<Integer> newPath = new ArrayList<>(path);
                        newPath.add(next.get(j));
                        queue.addLast(newPath);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < maxHeight.length; i++) {
            min  = Math.min(min, maxHeight[i]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < maxHeight.length; i++) {
            if (maxHeight[i] == min){
                result.add(i);
            }
        }

        return result;
    }


    public List<Integer> findNext(List<Integer> path, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();


        for (int i = 0; i < edges.length; i++) {
            int last = path.get(path.size() - 1);
            int left = edges[i][0];
            int right = edges[i][1];
            if (last == left) {
                if (path.contains(right)) {
                    continue;
                } else {
                    result.add(right);
                }
            } else if (last == right) {
                if (path.contains(left)) {
                    continue;
                } else {
                    result.add(left);
                }
            }
        }
        return result;
    }
}