import java.util.*;
class Solution {
    public String simplifyPath(String path) {
        String[] ss = path.split("/");
        // System.out.println(Arrays.toString(ss));
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ss.length; i++){
            if(ss[i].isEmpty() || ss[i].equals(".")){
                continue;
            }else if(ss[i].equals("..")){
                
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(ss[i]);
            }
        }
        // System.out.println(stack);
        while(!stack.isEmpty()){
            sb.append("/");
            sb.append(stack.pollLast());
        }
        if(sb.length() == 0){
            return "/";
        }
        return sb.toString() ;
    }
}
