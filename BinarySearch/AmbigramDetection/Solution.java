import java.util.*;

class Solution {
    public boolean solve(String s, String[][] pairs) {
        Map<String, Set<String>> map = new HashMap<>();
        for(String[] p : pairs){
            String a = p[0];
            String b = p[1];
            map.computeIfAbsent(a, (k -> new HashSet<>())).add(b);  
            map.computeIfAbsent(b, (k->new HashSet<>())).add(a);;  
        }

        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(!check(s.charAt(i), s.charAt(j), map)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    boolean check(char a, char b, Map<String, Set<String>> map){
        if(a == b) return true;
        String as = Character.toString(a);
        String bs = Character.toString(b);
        Queue<String> queue = new LinkedList<>();
        queue.add(as);
        Set<String> visited = new HashSet<>();
        visited.add(as);
        while(!queue.isEmpty()){
            String curr = queue.poll();
            if(curr.equals(bs)){
                return true;
            }
            Set<String> set = map.getOrDefault(curr, new HashSet<>());
            for(String e : set){
                if(!visited.contains(e)){
                    visited.add(e);
                    queue.add(e);
                }
            }
        }
        return false;
    }
}