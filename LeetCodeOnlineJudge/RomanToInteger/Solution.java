//Given a roman numeral, convert it to an integer.
//
//Input is guaranteed to be within the range from 1 to 3999.
public class Solution{
     public int romanToInt(String s) {
         if(s == null || s.length() == 0) return 0;
         int value[] = new int[256];
         value['#'] = 0;
         value['I'] = 1;
         value['V'] = 5;
         value['X'] = 10;
         value['L'] = 50;
         value['C'] = 100;
         value['D'] = 500;
         value['M'] = 1000;
         s = s + "#";
         int ret = 0;
         int len = s.length();
         for(int i = 0; i < len - 1; i++){
             if(value[s.charAt(i)] < value[s.charAt(i+1)]){
                 ret = ret - value[s.charAt(i)];
             }else{
                 ret = ret + value[s.charAt(i)];
             }

         }
         return ret;
     }
    public static void main(String args[]){
        Solution sol = new Solution();

    }
}
