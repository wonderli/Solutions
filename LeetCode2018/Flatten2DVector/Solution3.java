import java.util.*;
class Solution3{
	
}

class Vector2D {

    Deque<List<Integer>> stack = new ArrayDeque<>();
    Iterator<Integer> iter = null;
    public Vector2D(int[][] v) {
        for(int i = v.length - 1; i >= 0; i--){
            List<Integer> list = new ArrayList<>();
            int[] curr = v[i];
            for(int j = 0; j < curr.length; j++){
                list.add(curr[j]);
            }
            if(!list.isEmpty()){
                stack.push(list);    
            }
            
        }
        if(!stack.isEmpty()){
            iter = stack.pop().iterator();    
        }
    }
    
    public int next() {
        if(hasNext()){
            return iter.next();
        }
        return -1;
    }
    
    public boolean hasNext() {
        if(iter == null) return false;
        if(iter.hasNext()){
            return true;
        }
        
        if(!stack.isEmpty()){
            iter = stack.pop().iterator();
        }
        return iter.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
