//Given an absolute path for a file (Unix-style), simplify it.
//
//For example,
//path = "/home/", => "/home"
//path = "/a/./b/../../c/", => "/c"
import java.util.*;
public class Solution{
    public String simplifyPath(String path) {
        if(path == null) return null;
        path = "/" + path + "/";
        Stack<String> stack = new Stack<String>();
        String curr = new String();
        int len = path.length();
        for(int i = 1; i < len; i++){
            if(path.charAt(i) == '/'){
                if(curr.equals(".")){

                }else if(curr.equals("..")){
                    if(!stack.empty()){
                        stack.pop();
                    }
                }else if(!curr.equals("")){
                    stack.push(curr);
                }
                curr = new String();
            }else{
                curr = curr + path.charAt(i);
            }
        }
        if(stack.empty()){
            return new String("/");
        }else{
            String ret = new String();
            while(!stack.empty()){
                System.out.println(stack.peek());
                ret = "/" + stack.peek() + ret ;
                stack.pop();
            }
            return ret;
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String s = "/home/foo/.bashrc";
        System.out.println(sol.simplifyPath(s));
    }
}
