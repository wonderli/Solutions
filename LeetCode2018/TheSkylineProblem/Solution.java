import java.util.*;
public class Solution{
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b : buildings){
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int preMax = 0;
        for(int[] h : height){
            if(h[1] < 0){
                pq.add(-h[1]);
            }else {
                pq.remove(h[1]);
            }
            int currMax = pq.peek();
            if(currMax != preMax){
                res.add(new int[]{h[0], currMax});
                preMax = currMax;
            }
        }
        List<List<Integer>> ret = convert(res);
        return ret;
    }
    public List<List<Integer>> convert(List<int[]> res){

        List<List<Integer>> ret = new ArrayList<>();
        for(int[] e : res){
            List<Integer> curr = new ArrayList<>();
            curr.add(e[0]);
            curr.add(e[1]);
            ret.add(curr);
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
