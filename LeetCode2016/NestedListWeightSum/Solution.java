import java.util.*;
public class Solution{
	int depthSum(List<NestedInteger> nestedList){

		if(nestedList == null || nestedList.size() == 0) return 0;

		return depthSum(nestedList, 1);

	}

	public int depthSum(List<NestedInteger> nestedList, int depth){

		if(nestedList == null || nestedList.size() == 0) return 0;

		int sum = 0;

		if(nestedList.size() == 1){

			return depthSum(nestedList.get(0), depth);

		}else {

			for(NestedInteger e : nestedList){

				sum += depthSum(e, depth);

			}

		}

		return sum;

	}

	public int depthSum(NestedInteger ni, int depth){

		if (ni == null ) return 0;

		if (ni.isInteger()) return ni.getInteger() * depth;

		if (ni.getList() != null) return depthSum(ni.getList(), depth+1);

		return 0;

	}

	public static void main(String args[]){
		Solution sol = new Solution();
	}
}
