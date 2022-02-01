import java.util.*;
class Solution {
    int[] parent;
    int count;
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b)->(a[0] - b[0]));
        parent = new int[n];
        count = n;
        for(int i =0; i < n; i++){
            parent[i] = i;
        }
        
        for(int[] log: logs){
            union(log[1], log[2]);
            if(count == 1){
                return log[0];
            }
        }
        return -1;
    }
    
    private void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            parent[rootA] = rootB;
            count--;
        }
    }
    private int find(int a){
        if(parent[a] != a){
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
}
