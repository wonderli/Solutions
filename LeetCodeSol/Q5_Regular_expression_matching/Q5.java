public class Q5{
    public static boolean isMatch(String str, int strIndex, String pattern, int patternIndex){
        if(strIndex == (str.length() - 1)) return (patternIndex == (pattern.length() - 1));
        if(str == null) return (pattern == null); 
        if(pattern.length() == 1){
            if(pattern.charAt(0) == '*') return true;
            else if(pattern.charAt(0) == '.') return true;
            else if((str.charAt(0) != pattern.charAt(0)) && str.length() > 1) return false;
            else if((str.charAt(0) == pattern.charAt(0)) && str.length() == 1) return true;
        }else{
            if((patternIndex + 1 < pattern.length()) && (pattern.charAt(patternIndex + 1) != '*')) {
                return (str.charAt(strIndex) == pattern.charAt(patternIndex) || (pattern.charAt(patternIndex) == '.' && (strIndex != (str.length()-1))) && isMatch(str, strIndex+1, pattern, patternIndex+1));
            }
            while((str.charAt(strIndex) == pattern.charAt(patternIndex)) || (pattern.charAt(patternIndex) == '.' && ((str.length() - 1) < strIndex))){
                if(isMatch(str, strIndex, pattern, patternIndex+2)) return true;
                strIndex++;
            }

            return (((patternIndex + 2) < pattern.length()) && isMatch(str, strIndex, pattern, patternIndex + 2));
        }
        return false;
    }
    public static void main(String args[]){
        System.out.println(isMatch("abbbc", 0, "ab*c", 0));
        System.out.println(isMatch("ac", 0, "ab*c", 0));
        System.out.println(isMatch("abbc", 0, "ab*bbc", 0));
        System.out.println(isMatch("abcbcd", 0, "a.*c.*d", 0));
        System.out.println(isMatch("aa", 0, "a", 0));
        System.out.println(isMatch("aa", 0, "aa", 0));
        System.out.println(isMatch("aaa", 0, "aa", 0));
        System.out.println(isMatch("aa", 0, ".*", 0));
        System.out.println(isMatch("aab", 0, "c*a*b", 0));
    }
}
