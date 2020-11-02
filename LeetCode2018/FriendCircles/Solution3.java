import java.util.*;
public class Solution3{
    int count = 0;
    public int findCircleNum(int[][] M) {
        if(M.length == 0||M[0].length == 0) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = M.length;
        for(int j = 0; j < n;j++){
            for(int i = 0; i <n; i++){
                if(M[i][j] == 1){
                    List<Integer> curr = map.getOrDefault(i, new ArrayList<>());
                    curr.add(j);
                    map.put(i, curr);
                }
            }
        }
//        System.out.println(map);
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                visited.add(i);
                dfs(i, map, visited);
                count++;
            }

        }

        return count;
    }
    public void dfs(int index, Map<Integer, List<Integer>> map, Set<Integer> visited){

        List<Integer> list = map.get(index);
        for(int e : list){
            if(index != e && !visited.contains(e)){
                visited.add(e);
                dfs(e, map, visited);
            }
        }
    }

    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
