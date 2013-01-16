//Write a function to find the longest common prefix string amongst an array of strings. 
public class Solution{
     public String longestCommonPrefix(String[] strs) {
         if(strs == null) return null;
         if(strs.length == 0) return new String();
         int slen = strs.length;
         StringBuilder sb = new StringBuilder();
         int min = Integer.MAX_VALUE;
         for(int i = 0; i < slen; i++){
             if(strs[i].length() < min){
                 min = strs[i].length();
             }
         }
         boolean flag = true;
         for(int i = 0; i < min; i++){
             char c = strs[0].charAt(i);
             int count = 1;
             for(int j = 1; j < slen; j++){
                 if(c == strs[j].charAt(i)){
                     count++;
                 }else{
                     flag = false;
                     break;
                 }
             }
             if(flag == false){
                 break;
             }
             if(count == strs.length){
                 sb.append(c);
             }
         }
         return sb.toString();
     }
    public static void main(String args[]){
        Solution sol = new Solution();
        String[] strs = {"a"};
        System.out.println(sol.longestCommonPrefix(strs));
    }
}
