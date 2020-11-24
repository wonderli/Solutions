import java.util.*;
public class Solution{
    public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0;
        List<String> result = new ArrayList<>();
        while(left< words.length){
            int right = findRight(left, words, maxWidth);
            result.add(justify(left, right, words, maxWidth));
            left = right+1;
        }
        return result;
    }

    private int findRight(int left, String[] words, int maxWidth){
        int right = left;
        int sum = words[right].length();
        right++;
        while(right < words.length && (sum +1 + words[right].length())<= maxWidth){
            sum+=1 + words[right++].length();
        }
        return right -1;
    }

    private String justify(int left, int right, String[] words, int maxWidth){
        if(right - left ==0 ) return padResult(words[left], maxWidth);
        boolean isLastLine = right == words.length -1;
        int numSpaces = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);
        String space = isLastLine ? " " : blank(totalSpace/numSpaces);
        int remainder = isLastLine ? 0 :totalSpace % numSpaces;

        StringBuilder result = new StringBuilder();
        for(int i = left; i <= right; i++){
            result.append(words[i]).append(space).append(remainder > 0 ? " " :"");
            remainder--;
        }
        return padResult(result.toString().trim(), maxWidth);
    }

    private int wordsLength(int left, int right, String[] words){
        int len = 0;
        for(int i = left; i <= right; i++){
            len += words[i].length();
        }
        return len;
    }
    private String padResult(String result, int maxWidth){
        return result + blank(maxWidth - result.length());
    }
    private String blank(int len){
        return new String(new char[len]).replace('\0', ' ');
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
