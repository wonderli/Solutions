import java.util.*;
class Solution {
	int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	int m;
	int n;
	public int cutOffTree(List<List<Integer>> forest) {
		m = forest.size();
		n = forest.get(0).size();
		List<int[]> trees = new ArrayList<>();
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				int v = forest.get(i).get(j);
				if(v > 1) trees.add(new int[]{v, i, j});
			}
		}
		Collections.sort(trees, (a, b) -> (a[0] - b[0]));
		int ans = 0;
		int sr = 0;
		int sc = 0;
		for(int[] tree : trees){
			int d = bfs(forest, sr, sc, tree[1], tree[2]);
			if(d < 0) return -1;
			ans += d;
			sr = tree[1];
			sc = tree[2];
		}
		return ans;
	}
	private int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc){
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{sr, sc, 0});
		boolean[][] visited = new boolean[m][n];
		visited[sr][sc] = true;
		while(!queue.isEmpty()){
			int[] curr = queue.poll();
			if(curr[0] == tr && curr[1] == tc) return curr[2];
			for(int[] d : directions){
				int x = curr[0] + d[0];
				int y = curr[1] + d[1];
				if(0 <= x && x < m && 0 <= y && y < n && !visited[x][y] && forest.get(x).get(y) > 0){
					queue.add(new int[]{x, y, curr[2] + 1});
					visited[x][y] = true;
				}
			}
		}
		return -1;
	}
}