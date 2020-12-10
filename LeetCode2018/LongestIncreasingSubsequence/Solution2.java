import java.util.*;
public class Solution2{
	public int lengthOfLIS(int[] nums) {
	        List<Integer> piles = new ArrayList<>();
	        for(int n : nums){
	            int pile = Collections.binarySearch(piles, n);
	            if(pile < 0) {
	                // pile = ~pile
	                pile = - (pile + 1);
	            }
	            if(pile == piles.size()){
	                piles.add(n);
	            }else{
	                piles.set(pile, n);
	            }
	        }
	        return piles.size();
	    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}