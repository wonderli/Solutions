import java.util.*;

class Solution {
    int[][] directions = {
        {-2, -1}, {-2, 1},
        {-1, -2}, {-1, 2},
        {1, -2}, {1, 2},
        {2, -1}, {2, 1}
    };
    public int minKnightMoves(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        
        int steps = 0;
        queue.add(new int[]{0, 0});
        boolean[][] visited =new boolean[605][605];
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                if(p[0] == x && p[1] == y){
                    return steps;
                }
                int a = p[0];
                int b = p[1];
                for (int[] d : directions) {
                    int dx = a + d[0];
                    int dy = b + d[1];
                    if (!visited[dx + 302][dy + 302]){
                        queue.add(new int[]{dx, dy});
                        visited[dx + 302][dy + 302] = true;
                    }
                }
            }
            steps++;
        }
        return steps;
    }
}