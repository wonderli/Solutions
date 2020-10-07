import java.util.*;

class Solution2 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0];
            }
        });
        for (int[] interval : intervals) {
            pq.add(interval);
        }
        List<int[]> res = new ArrayList<>();
        int[] first = pq.poll();
        int start = first[0];
        int end = first[1];
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (end < curr[0]) {
                res.add(new int[]{start, end});
                start = curr[0];
                end = curr[1];
            } else if (end >= curr[0]) {
                end = curr[1] > end ? curr[1] : end;
            }
        }

        int[] last = res.isEmpty() ? null : res.get(res.size() - 1);
        if (last == null ||last[0] != start && last[1] != end) {
            res.add(new int[]{start, end});
        }

        int[][] ret = new int[res.size()][2];
        for (int i = 0; i < ret.length; i++) {
            ret[i][0] = res.get(i)[0];
            ret[i][1] = res.get(i)[1];
        }
        return ret;
    }
    public static void main(String[] args){
        int[][] intervals = {{1, 4}, {0, 4}};
        Solution2 sol = new Solution2();
        int[][] res =sol.merge(intervals);
        System.out.println(res);
    }
}
