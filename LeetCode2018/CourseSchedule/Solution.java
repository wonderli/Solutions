import java.util.*;

public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses <= 0) {
			return false;
		}
		Queue<Integer> queue = new LinkedList<>();
		int[] inDegree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			inDegree[prerequisites[i][1]]++;
		}
        System.out.println(Arrays.toString(inDegree));
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}
        System.out.println(queue);
		while (!queue.isEmpty()) {
			int x = queue.poll();
			for (int i = 0; i < prerequisites.length; i++) {
				if (x == prerequisites[i][0]) {
					inDegree[prerequisites[i][1]]--;
					if (inDegree[prerequisites[i][1]] == 0) {
						queue.add(prerequisites[i][1]);
					}
				}
			}
		}
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		int n = 4;
//        int[][] p = {{2,0},{1,0},{3,1},{3,2},{1,3}};
		int[][] p = { { 3, 0 }, { 0, 1 } };
		System.out.println(sol.canFinish(n, p));
	}
}
