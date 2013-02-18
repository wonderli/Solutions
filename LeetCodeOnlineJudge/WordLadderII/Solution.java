import java.util.*;
public class Solution{
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        Queue<String> actionQueue = new LinkedList<String>();
        Set<String> visitedSet = new HashSet<String>();
        Map<String, ArrayList<String>> backtrackMap = new TreeMap<String, ArrayList<String>>();
        actionQueue.add(start);
        visitedSet.add(start);
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        while(!actionQueue.isEmpty()){
            String w = actionQueue.poll();
            for(String v: getOneEditWords(w)){
                System.out.println("v " + v);
                if(v.equals(end)){
                    LinkedList<String> list = new LinkedList<String>();
                    list.add(v);
                    while(w != null){
                        list.add(0, w);
                        ArrayList<String> b = backtrackMap.get(w);
                    }
                    ret.add(new ArrayList<String>(list));
                }
                if(dict.contains(v)){
                    if(!visitedSet.contains(v)){
                        actionQueue.add(v);
                        visitedSet.add(v);
                        if(!backtrackMap.contains(v)){
                            ArrayList<String> a = new ArrayList<String>();
                            a.add(w);
                            backtrackMap.put(v, a);
                        }else{
                            ArrayList<String> a = backtrackMap.get(v);
                            a.add(w);
                            backtrackMap.put(v, a);
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(ArrayList<String> e : ret){
            if(e.size() < min)
                min = e.size();
        }
        ArrayList<ArrayList<String>> minimum = new ArrayList<ArrayList<String>>();
        for(ArrayList<String> e : ret){
            if(e.size() == min){
                minimum.add(e);
            }
        }
        return minimum;
    }
    public Set<String> getOneEditWords(String word){
        Set<String> words = new TreeSet<String>();
        for(int i = 0; i < word.length(); i++){
            char wordArray[] = word.toCharArray();
            for(int j = 0; j < 26; j++){
                char c = (char)('a' + j);
                if(word.charAt(i) != c){
                    wordArray[i] = c;
                    words.add(new String(wordArray));
                }
            }
        }
        return words;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String start = "hot";
        String end = "dog";
        HashSet<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dog");
        dict.add("cog");
        dict.add("pot");
        dict.add("dot");
        ArrayList<ArrayList<String>> ret = sol.findLadders(start, end, dict);
        for(ArrayList<String> e : ret){
            System.out.println(e);
        }
    }
}
