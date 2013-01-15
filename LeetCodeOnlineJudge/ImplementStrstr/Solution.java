public class Solution{
    public String strStr(String haystack, String needle) {
        char t[] = haystack.toCharArray();
        char p[] = needle.toCharArray();
        int tLen = t.length;
        int pLen = p.length;
        int i = 0;
        int j = 0;
        int begin = 0;
        while(i < tLen && j < pLen){
            if(t[i] == p[j]){
                i++;
                j++;
            }else{
                if(t[i] != p[j]){
                    i = begin;
                    begin++;
                    j = 0;
                }
            }
        }
        if(j == pLen){
            return haystack.substring(i - pLen);
        }
        return null;
    }
    public static void main(String args[]){
        String t = new String("aaa");
        String p = new String("aaaa");
        Solution s = new Solution();
        System.out.println(s.strStr(t, p));
    }
}
