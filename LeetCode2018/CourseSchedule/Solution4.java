import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution4 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] e : prerequisites) {
            int a = e[0];
            int b = e[1];
            indegree[b]++;
            graph[a].add(b);
        }

        int count =0;
        Queue<Integer> queue =new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
                count++;
            }
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();
            List<Integer> depends = graph[curr];
            for(int e : depends){
                indegree[e]--;
                if(indegree[e] == 0){
                    queue.add(e);
                    count++;
                }
            }
        }
        if(count == numCourses){
            return true;
        }else{
            return false;
        }

    }
}