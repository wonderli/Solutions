import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Map<String, Integer> map = new HashMap<>();
        for(String e : emails){
            String unique = get(e);
            map.put(unique, map.getOrDefault(e, 0) + 1);
        }
        // System.out.println(map);
        return map.size();
    }

    private String get(String s){
        String[] split = s.split("@");
        String domain = split[1];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < split[0].length(); i++){
            char c = split[0].charAt(i);
            if(c == '.') {
                continue;
            }else if(c == '+'){
                break;
            }else{
                sb.append(c);
            }
        }
        // System.out.println(sb);
        sb.append("@");
        sb.append(domain);
        return sb.toString();
    }

}