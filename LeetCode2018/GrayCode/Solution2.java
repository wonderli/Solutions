import java.util.*;
class Solution{
	public List<Integer> grayCode(int n){
		List<Integer> result = new ArrayList<>();
		result.add(0);
		for(int i = 0; i < n; i++){
			List<Integer> l1 = result;
			List<Integer> l2 = new ArrayList<>(l1);
			Collections.reverse(l2);
			int prependVal = (1 << i);
			for(int j = 0; j < l2.size(); j++){
				l2.set(j, l2.get(j) | prependVal);
			}
			l1.addAll(l2);
		}
		return result;
	}
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

