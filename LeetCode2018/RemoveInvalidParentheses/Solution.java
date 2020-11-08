import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) return Collections.singletonList("");
       

        Set<String> ret = new HashSet<>();
        helper(s, 0, 0, 0, new StringBuilder(), ret);

        List<String> ans = new ArrayList<>();
        int max = 0;
        for(String e : ret){
            if(e.length() > max){
                max = e.length();
                ans = new ArrayList<>();
                ans.add(e);
            }else if(e.length() == max){
                ans.add(e);
            }
        }
        return ans;
    }

    private void helper(String s, int index, int left, int right, StringBuilder sb, Set<String> ret) {
        if (index >= s.length()){
            if(left == right) {
                ret.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(index);
        if (c != '(' && c != ')') {
            sb.append(c);
            helper(s, index + 1, left, right, sb, ret);
            sb.setLength(sb.length() - 1);
            return;
        }

        if (c == '(') {
            sb.append(c);
            helper(s, index + 1, left + 1, right, sb, ret);
            sb.setLength(sb.length() - 1);
            
        } else if (c == ')') {
            if (right < left) {
                sb.append(c);
                helper(s, index + 1, left, right + 1, sb, ret);
                sb.setLength(sb.length() - 1);
            }
        }
        
        helper(s, index + 1, left, right, sb, ret);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "()())()";
        System.out.println(sol.removeInvalidParentheses(s));
    }
}