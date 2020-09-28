import java.util.*;

public class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.count - b.count;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Pair p = new Pair(entry.getKey(), entry.getValue());
            if (pq.size() == k) {
                if (pq.peek().count < p.count) {
                    pq.poll();
                    pq.add(p);
                }
            } else if (pq.size() < k) {
                pq.add(p);
            }

        }
        int[] ret = new int[pq.size()];
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            ret[i] = pq.poll().num;
        }
        return ret;
    }

    public static void main(String args[]) {
        Solution2 sol = new Solution2();
        int[] a = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(sol.topKFrequent(a, k)));
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
