import java.util.*;
class Solution3 {
	public List<String> letterCasePermutation(String S) {
		List<String> result = new ArrayList<>();
		char[] s = S.toCharArray();
		helper(s, 0, result);
		return result;
	}
	private void helper(char[] s, int index, List<String> result){
		if(index == s.length){
			result.add(new String(s));
			return;
		}
        
		char c = s[index];
		if(Character.isDigit(c)){
			helper(s, index+1, result);
		}else{
			char lower = Character.toLowerCase(c);
			s[index] = lower;
			helper(s, index+1, result);
			char upper = Character.toUpperCase(c);
			s[index]= upper;
			helper(s, index+1, result);
			s[index] = c;
		}
        
	}
}
