class Solution3 {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[256];
        for(char c : s.toCharArray()){
            map[c]++;
        }
        int count = 0;
        for(int i = 0; i < 256; i++){
            if(map[i] %2 == 1){
                count++;
            }
        }
        return count <= 1;
    }
}