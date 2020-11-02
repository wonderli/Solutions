import java.util.*;
public class Solution2{
    public int findCircleNum(int[][] M) {
        int n = M.length;
        boolean[] visited =new boolean[n];
        Queue<Integer> queue= new LinkedList<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                queue.add(i);
                while(!queue.isEmpty()){
                    int curr = queue.poll();
                    visited[curr] = true;
                    for(int j = 0; j < n; j++){
                        if(M[curr][j] == 1 && !visited[j]){
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
