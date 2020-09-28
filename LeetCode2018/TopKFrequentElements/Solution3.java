import java.util.*;

public class Solution3 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return b.count - a.count;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Pair p = new Pair(entry.getKey(), entry.getValue());
            pq.add(p);

        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = pq.poll().num;
        }
        return ret;
    }
}
    class Pair {
    int num;
    int count;

    public Pair(int n, int c) {
        num = n;
        count = c;
    }
}

