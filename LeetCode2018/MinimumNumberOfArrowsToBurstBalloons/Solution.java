import java.util.*;
public class Solution{
    public int findMinArrowShots(int[][] points) {
        if(points == null ||points.length == 0) return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>( new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]) return a[1] > b[1] ? 1 : -1;
                return a[0] > b[0] ? 1 : -1;
            }
        });

        for(int[] p : points){
            pq.add(p);
        }

        int[] first = pq.poll();
        int start = first[0];
        int end = first[1];
        List<int[]> res = new ArrayList<>();
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[0] <= end){
                start = curr[0];
                end = Math.min(end, curr[1]);
//                res.add(new int[]{start, end});
            }else{
                res.add(new int[]{start, end});
                start = curr[0];
                end = curr[1];
            }
        }
        res.add(new int[]{start, end});

        print(res);
        return res.size();
    }

    private void print(List<int[]> res) {
        for(int[] e : res){
            System.out.print(String.format("[%d, %d] ", e[0], e[1]));
        }
        System.out.println();
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        int[][] a= {{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(sol.findMinArrowShots(a));

    }
}
