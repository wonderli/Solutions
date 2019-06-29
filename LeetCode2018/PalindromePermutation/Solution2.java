class Solution2 {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        char[] sArr = s.toCharArray();
        int[] dict = new int[256];
        for(int i = 0; i < sArr.length; i++){
            int index = sArr[i];
            dict[index]++;
            if(dict[index] == 2){
                dict[index] = 0;
            }
        }
        int val = 0;
        for(int i = 0; i < dict.length; i++){
            val += dict[i];
        }
        return (val == 0 && sArr.length % 2 == 0) || (val == 1 && sArr.length % 2 == 1);
    }
}