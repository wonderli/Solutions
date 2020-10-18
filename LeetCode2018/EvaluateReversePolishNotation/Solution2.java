import java.util.*;
public class Solution2{

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(isOperator(token)){
                int b = stack.pop();
                int a = stack.pop();
                if(token.equals("+")){
                    int c = a + b;
                    stack.push(c);
                }else if(token.equals("-")){
                    int c = a - b;
                    stack.push(c);
                }else if(token.equals("*")){
                    int c = a * b;
                    stack.push(c);
                }else if(token.equals("/")){
                    int c = a/b;
                    stack.push(c);
                }
            }else {
                int a = Integer.valueOf(token);
                stack.push(a);
            }
        }
        return stack.pop();
    }
    private boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
