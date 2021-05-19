import java.util.*;
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(String path : paths){
            String[] split = path.split(" ");
            String pre = split[0];
            for(int i = 1; i < split.length; i++){
                String content = split[i];
                String[] nameContent = content.split("\\(");
                nameContent[1] = nameContent[1].replace(")", "");
                String p = String.format("%s/%s", pre, nameContent[0]);
              
                map.computeIfAbsent(nameContent[1], (k -> new ArrayList<>())).add(p);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> v : map.values()){
            if(v.size() > 1){
                result.add(v);    
            }
            
        }
        return result;
    }
}