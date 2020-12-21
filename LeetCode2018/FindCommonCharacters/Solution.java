import java.util.*;
class Solution {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        String common = A[0];
        for(int i = 1; i < A.length; i++){
            common = common(A[i], common);
        }
        return convert(common);
    }
    
    private String common(String a, String b){
        int[] map = new int[256];
        for(char c : a.toCharArray()){
            map[c]++;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : b.toCharArray()){
            map[c]--;
            if(map[c] >= 0){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    private List<String> convert(String result){
        List<String> res = new ArrayList<>();
        for(char e : result.toCharArray()){
            res.add(Character.toString(e));
        }
        return res;
    }
}