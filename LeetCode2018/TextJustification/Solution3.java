import java.util.*;
class Solution3 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> currLine = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int currLen = 0;
        int n = words.length;
        for(int i = 0; i < n; i++){
            if(currLen + words[i].length() + currLine.size() > maxWidth){
                String line = generate(currLen, currLine, maxWidth);
                result.add(line);
                currLen = 0;
                currLine.clear();
            }
            currLine.add(words[i]);
            currLen += words[i].length();
        }
        if(!currLine.isEmpty()){
            String lastLine = generateLastLine(maxWidth, currLine);
            result.add(lastLine);
        }
        return result;
    }
    private String getSpaces(int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(" ");
        }
        return sb.toString();
    }
    
    private String generate(int len, List<String> curr, int maxWidth){
        if(curr.size() == 1){
            return curr.get(0) + getSpaces(maxWidth - len);
        }
        
        int spaces = (maxWidth - len) / (curr.size() - 1);
        int extraSpaces = (maxWidth - len) % (curr.size() - 1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < curr.size() - 1; i++){
            sb.append(curr.get(i));
            sb.append(getSpaces(spaces));
            if(i < extraSpaces){
                sb.append(getSpaces(1));
            }
        }
        sb.append(curr.get(curr.size()-1));
        return sb.toString();
    }
    private String generateLastLine(int maxWidth, List<String> curr){
        String last = String.join(" ", curr);
        return last + getSpaces(maxWidth - last.length());
    }
    
    
}
