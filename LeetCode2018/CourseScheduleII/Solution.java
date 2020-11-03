import java.util.*;
public class Solution{
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        for(int[] p : prerequisites){
            int a = p[0];
            int b = p[1];
            inDegrees[b]++;
            List<Integer> list = map.getOrDefault(a, new ArrayList<>());
            list.add(b);
            map.put(a, list);
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(inDegrees[i] == 0){
                queue.add(i);
            }
        }
        int j = numCourses-1;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            res[j] = curr;
            List<Integer> l = map.getOrDefault(curr, new ArrayList<>());
            for(int e : l){
                inDegrees[e]--;
                if(inDegrees[e] == 0){
                    queue.add(e);
                }
            }
            j--;
        }
        return j > 0 ? new int[0] : res;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
