import java.util.*;
class Solution {
    public String largestNumber(int[] nums) {
        String[] sorted = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            sorted[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(sorted, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                String o1 = a + b;
                String o2 = b + a;
                return o2.compareTo(o1);
            }
        });
        
        if(sorted[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String s : sorted){
            sb.append(s);
        }
        return sb.toString();
    }
}