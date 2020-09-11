import java.util.*;
public class Solution{
    Set<String> symbol = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    public int evalRPN(String[] tokens) {
        if(tokens == null) return 0;
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(!symbol.contains(s)){
                stack.push(Integer.parseInt(s));
            }else {
                int b = stack.pop();
                int a = stack.pop();
                int c = 0;
                switch(s){
                    case "+":
                        c = a + b;
                        break;
                    case "-":
                        c = a - b;
                        break;
                    case "*":
                        c = a * b;
                        break;
                    case "/":
                        c = a / b;
                        break;
                }
                stack.push(c);
            }
        }
        return stack.pop();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

