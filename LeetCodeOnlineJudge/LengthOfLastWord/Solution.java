//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//
//If the last word does not exist, return 0.
//
//Note: A word is defined as a character sequence consists of non-space characters only.
//
//For example,
//Given s = "Hello World",
//return 5.
//» Solve this problem
public class Solution{
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() < 1) return 0;
        char sa[] = s.toCharArray();
        int len = s.length();
        int start = len - 1;
        boolean sf = false;
        boolean ef = false;
        int end = 0;
        int i = len - 1;
        while(i >= 0){
            if(sa[i] != ' ' ){
                start = i;
                sf = true;
                break;
            }
            i--;
        }
        while( i >= 0){
            if(sa[i] == ' '){
                end = i;
                ef = true;
                break;
            }
            i--;
        }
        if(sf && ef) return start - end;
        if(!sf) return 0;
        if(sf && !ef) return start - end + 1;
        return s.length();
    }
    public static void main(String args[]){
        Solution s = new Solution();
        String str = new String("aa ");
        System.out.println(s.lengthOfLastWord(str));
    }
}
