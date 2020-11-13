import java.util.*;
class Solution {
    
    private class HeapNode{
        int value;
        int i;
        int j;
        public HeapNode(int value, int i, int j){
            this.value = value;
            this.i = i;
            this.j = j;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<HeapNode> pq = new PriorityQueue<>(new Comparator<HeapNode>(){
            @Override
            public int compare(HeapNode a, HeapNode b){
                return a.value - b.value;
            }
        });
        
        for(int i = 0; i < matrix.length; i++){
            HeapNode curr = new HeapNode(matrix[i][0], i, 0);
            pq.add(curr);
        }
        
        HeapNode curr = pq.peek();
        while(k > 0){
            curr = pq.poll();
            int r = curr.i;
            int c = curr.j;
            if(c < matrix[r].length - 1){
                pq.add(new HeapNode(matrix[r][c+1], r, c+1));
            }
            k--;
        }
        return curr.value;
    }
}