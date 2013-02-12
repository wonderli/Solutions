import java.util.*;
public class Solution2{
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if(start == null || end == null) return 0;
        if(start.equals(end) && dict.isEmpty()) return 0;
        HashSet<String> used = new HashSet<String>();
        HashSet<String> curr = new HashSet<String>();
        curr.add(start);
        int dist = 1;
        while(!curr.isEmpty()){
            HashSet<String> tmp = new HashSet<String>();
            dist++;
            for(String e : curr){
                char[] str = e.toCharArray();
                for(int i = 0; i < str.length; i++){
                    for(int j = 0; j < 26; j++){
                        if(str[i] != (char)('a' + j)){
                            char temp = str[i];
                            str[i] = (char)('a' + j);
                            String candidate = new String(str);
                            if(candidate.equals(end)){
                                return dist;
                            }
                            if(!used.contains(candidate) && dict.contains(candidate)){
                                tmp.add(candidate);
                                used.add(candidate);
                            }
                            str[i] = temp;
                        }
                    }
                    curr = tmp;
                }
            }
        }
        return 0;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
         String s = "ta";
         String e = "if";
         HashSet<String> set = new HashSet<String>();
         set.add("ts");
         set.add("sc");
         set.add("ph");
         set.add("ca");
         set.add("jr");
         set.add("hf");
         set.add("to");
         set.add("if");
         set.add("ha");
         set.add("is");
         set.add("io");
         set.add("cf");
         set.add("ta");
        //String s = "hot";
        //String e = "dog";
        //HashSet<String> set = new HashSet<String>();
        //set.add("cog");
        //set.add("tot");
        //set.add("hog");
        //set.add("hop");
        //set.add("pot");
        //set.add("dot");
        int ret = sol.ladderLength(s, e, set);
        System.out.println(ret);
    }
}
