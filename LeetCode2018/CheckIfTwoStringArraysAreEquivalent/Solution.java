class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int w1Len = word1.length;
        int i = 0;
        int w1Index = 0;
        int w2Len = word2.length;
        int w2Index = 0;
        int j = 0;
        while(w1Index < w1Len && w2Index < w2Len){
            char a = word1[w1Index].charAt(i);
            i++;
            if(i == word1[w1Index].length()){
                i = 0;
                w1Index++;
            }
            char b = word2[w2Index].charAt(j);
            j++;
            if(j == word2[w2Index].length()){
                j = 0;
                w2Index++;
            }
             if(a != b) return false;
        }
        return w1Index == w1Len && w2Index == w2Len;
    }
}