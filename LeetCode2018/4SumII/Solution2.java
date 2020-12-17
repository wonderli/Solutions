import java.util.*;
public class Solution2{
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		return kSum(new int[][]{A, B, C, D});
	}
	private int kSum(int[][] lists){
		Map<Integer, Integer> map = new HashMap<>();
		addToHash(lists, map, 0, 0);
		return countComplements(lists, map, lists.length/2, 0);
	}
	private void addToHash(int[][] lists, Map<Integer, Integer> map, int index, int sum){
		if(index == lists.length/2){
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}else{
			for(int e : lists[index]){
				addToHash(lists, map, index + 1, sum + e);
			}
		}
	}
	private int countComplements(int[][] lists, Map<Integer, Integer> map, int index, int complement){
		if(index == lists.length){
			return map.getOrDefault(complement, 0);
		}
		int count = 0;
		for(int e : lists[index]){
			count += countComplements(lists, map, index+1, complement - e);
		}
		return count;
	}
	public static void main(String args[]){
		Solution2 sol = new Solution2();
	}
}
