import java.util.*;
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs.length == 0) return new String[0];
        
        List<String> digits = new ArrayList<>();
        List<String> letters = new ArrayList<>();
        for(String s : logs){
            String[] ss = s.split(" ");
            if(Character.isDigit(ss[1].charAt(0))){
                digits.add(s);
            }else{
                letters.add(s);
            }
        }
        Collections.sort(letters, new Comparator<String>(){
            public int compare(String a, String b){
                String[] aa = a.split(" ");
                String[] bb = b.split(" ");
                int i = 1;
                int j = 1;
                String x = "";
                String y = "";
                while(i < aa.length && j < bb.length){
                    x = aa[i];
                    y = bb[j];
                    if(x.equals(y)){
                        i++;
                        j++;
                    }else{
                        break;
                    }
                }
                if(x.equals(y)){
                    return aa[0].compareTo(bb[0]);
                }
                return x.compareTo(y);
            }
        });
        String[] result = new String[logs.length];
        letters.addAll(digits);
        for(int i = 0; i < result.length; i++){
            result[i] = letters.get(i);
        }
        return result;
    }
}
