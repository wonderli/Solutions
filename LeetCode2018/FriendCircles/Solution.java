import java.util.*;
class Solution {
    
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(M, i, visited);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int[][] M, int index, boolean[] visited){
        for(int j = 0; j < M.length; j++){
            if(M[index][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(M, j, visited);
            }
        }
    }
    public static void main(String[] args){
        int[][] a = {{1,1,0}, {1, 1, 0}, {0, 0, 1}};
        Solution sol = new Solution();
        System.out.println(sol.findCircleNum(a));
    }
}