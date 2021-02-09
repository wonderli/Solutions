import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution2 {
    int m;
    int n;
    private class Pair{
        int first;
        int second;
        public Pair(int f, int s){
            first = f;
            second = s;
        }

        @Override
        public String toString(){
            return String.format("[%d, %d]", first, second);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
    public int numDistinctIslands(int[][] grid) {
        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<Set<Pair>> islands = new HashSet<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j<n;j++){
                Set<Pair> set = new HashSet<>();
                dfs(grid, i, j, i, j, visited, set);
                // System.out.println(set);
                if(!set.isEmpty()){
                    islands.add(set);
                }
            }
        }
        return islands.size();
    }

    private void dfs(int[][] grid, int i, int j, int startX, int startY, boolean[][] visited, Set<Pair> set){
        if(i < 0 || i>=m || j < 0 || j >= n ) return;
        if(grid[i][j] == 0 || visited[i][j]) return;
        visited[i][j] = true;
        set.add(new Pair(i - startX, j - startY));
        dfs(grid, i+1, j, startX, startY, visited, set);
        dfs(grid, i-1, j, startX, startY, visited, set);
        dfs(grid, i, j+1, startX, startY, visited, set);
        dfs(grid, i, j-1, startX, startY, visited, set);
    }
}
