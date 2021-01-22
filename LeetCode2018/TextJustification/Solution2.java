import java.util.*;
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> curLine = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int totalLength = 0;
        for (int i = 0; i < words.length; i++) {
            if (totalLength + curLine.size() + words[i].length() > maxWidth) {
                res.add(generate(curLine, totalLength, maxWidth));
                curLine.clear();
                totalLength = 0;
            }
            totalLength += words[i].length();
            curLine.add(words[i]);
        }
        if (!curLine.isEmpty()) {
            String lastLine = String.join(" ", curLine);
            
            res.add(lastLine + getSpaces(maxWidth - lastLine.length()));
            
        }
        return res;
    }
    private String generate(List<String> curLine, int totalLength, int maxWidth) {
        if (curLine.size() == 1) {
            return curLine.get(0)  + getSpaces(maxWidth - totalLength);
        }
        int spaces = (maxWidth - totalLength)/(curLine.size() - 1);
        int biggerSpaces = (maxWidth - totalLength)  % (curLine.size() - 1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < curLine.size() - 1; i++) {
            res.append(curLine.get(i) + getSpaces(spaces));
            if (i < biggerSpaces)
                res.append(getSpaces(1));
        }
        res.append(curLine.get(curLine.size() - 1));
        return res.toString();
    }
    private String getSpaces(int n) {
        StringBuilder str = new StringBuilder(); 
        }
        return str.toString();
    }
}
