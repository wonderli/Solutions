import java.util.Stack;

public class Solution {
    public int scoreOfParentheses(String S) {
        Stack<String> stack = new Stack<>();

        for(char c : S.toCharArray()){
            if(c == '('){
                stack.push("(");
            }else if(c == ')'){
                String x = stack.peek();
                if(x.equals("(")){
                    stack.pop();
                    stack.push("1");
                }else{
                    int tmp = 0;
                    while(!stack.peek().equals("(")){
                        tmp += Integer.valueOf(stack.pop());
                    }
                    stack.pop();
                    stack.push(Integer.toString(tmp * 2));
                }
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += Integer.valueOf(stack.pop());
        }
        return result;
    }
     public static void main(String[] args) {
         Solution sol = new Solution();
         String s = "(()(()))";
         System.out.println(sol.scoreOfParentheses(s));
      }
}