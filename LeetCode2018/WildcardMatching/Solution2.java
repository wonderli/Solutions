class Solution2 {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        
        int starIndex = -1;
        int sTempIndex = -1;
        int sIndex = 0;
        int pIndex = 0;
        while(sIndex < sLen){
            if(pIndex < pLen && (p.charAt(pIndex) == '?' || p.charAt(pIndex) == s.charAt(sIndex))){
                sIndex++;
                pIndex++;
            }else if(pIndex < pLen && p.charAt(pIndex) == '*'){
                starIndex = pIndex;
                sTempIndex = sIndex;
                pIndex++;
            }else if(starIndex == -1){
                return false;
            }else{
                sIndex = sTempIndex +1;
                pIndex = starIndex+1;
                sTempIndex = sIndex;
            }
        }
        
        for(int i = pIndex; i < pLen; i++){
            if(p.charAt(i) != '*')return false;
        }
        return true;
    }
}