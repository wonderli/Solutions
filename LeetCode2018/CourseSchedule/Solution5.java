import java.util.*;
class Solution5 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> nexts = new HashMap<>();
        int[] indegree = new int[numCourses];
        buildGraph(nexts, indegree, prerequisites, numCourses);
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited++;
            for (Integer next: nexts.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                } else if (indegree[next] < 0) {
                    return false;
                }
            }
        }
        return visited == numCourses;
    }
    private void buildGraph(Map<Integer, Set<Integer>> nexts, int[] indegree, int[][] prerequisites, int numCourses) {
        for (int i = 0; i < numCourses; i++) {
            nexts.put(i, new HashSet<>());
        }
        for (int[] prereq: prerequisites) {
            nexts.get(prereq[1]).add(prereq[0]);
            indegree[prereq[0]]++;
        }
    }
}