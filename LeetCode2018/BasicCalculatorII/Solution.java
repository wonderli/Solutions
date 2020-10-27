import java.util.*;
public class Solution{
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
		int curr =0;
		char lastSign = '+';
		int len = s.length();
		for(int i = 0; i <len; i++){
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				curr = curr * 10 + (c - '0');
			}
			if(!Character.isDigit(c) && !Character.isWhitespace(c) || i ==len -1){
				if(lastSign == '+'){
					stack.push(curr);
				}else if(lastSign == '-'){
					stack.push(-curr);
				}else if(lastSign == '*'){
					stack.push(stack.pop() * curr);
				}else if(lastSign == '/'){
					stack.push(stack.pop() / curr);
				}
				curr = 0;
				lastSign =c;
			}
		}
		int res = 0;
		while(!stack.isEmpty()){
			res += stack.pop();
		}
		return res;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
