import java.util.*;
class Solution {
    private class Pair{
        Integer index;
        Boolean isLeft;
        public Pair(Integer index, Boolean isLeft){
            this.index = index;
            this.isLeft = isLeft;
        }
    }
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> set = new HashSet<>();
        int maxJump = 2000 + 2 * b;
        for(int f : forbidden){
            set.add(f);
            maxJump = Math.max(f + 2 * b, maxJump);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, false));
        Set<Integer> visited = new HashSet<>();
        int moves = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair p = queue.poll();
                int index = p.index;
                if(index == x){
                    return moves;
                }
                if(visited.contains(index)){
                    continue;
                }
                visited.add(index);
                int left = index - b;
                int right = index + a;
                if(!p.isLeft && left >= 0 && !set.contains(left)){
                    queue.add(new Pair(left, true));
                }
                if(!set.contains(right) && right <= maxJump){
                    queue.add(new Pair(right, false));
                }
            }
            moves++;
        }
        return -1;
    }
}