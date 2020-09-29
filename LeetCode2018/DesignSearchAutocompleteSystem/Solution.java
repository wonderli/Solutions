import java.util.*;
class AutocompleteSystem {

    TrieNode root;
    String input;
    public AutocompleteSystem(String[] sentences, int[] times) {
        build(sentences, times);
        this.input = "";
    }

    public List<String> input(char c) {
        if(c == '#'){
            build(input, 1);
            input = "";
            return Collections.emptyList();
        }else {
            input = input + c;
            return search(input);
        }
    }
    public List<String> search(String s){
        TrieNode curr = root;
        for(char c : s.toCharArray()){
            if(!curr.children.containsKey(c)){
                return Collections.emptyList();
            }
            curr = curr.children.get(c);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                if(p1.times == p2.times){
                    return p1.s.compareTo(p2.s);
                }
                else return p2.times - p1.times;
            }
        });

        List<String> ret = new ArrayList<>();
        for(String e : curr.times.keySet()){
            pq.add(new Pair(e, curr.times.get(e)));
        }
        for(int i = 0; !pq.isEmpty() && i < 3; i++){
            ret.add(pq.poll().s);
        }
        return ret;
    }


    private void build(String[] sentences, int[] times){
        root = new TrieNode();
        for(int i = 0; i < sentences.length; i++){
            build(sentences[i], times[i]);
        }
    }

    private void build(String s, int times){
        TrieNode curr = root;
        for(char c : s.toCharArray()){
            if(!curr.children.containsKey(c)) {
                TrieNode t = new TrieNode();
                curr.children.put(c, t);
            }
            curr = curr.children.get(c);
            curr.times.put(s, curr.times.getOrDefault(s, 0) + times);
        }
        curr.isEnd = true;
    }

    public static void main(String[] args){

        String[] s = {"i love you","island","iroman","i love leetcode"};
        int[] times= {5, 3, 2, 2};
        AutocompleteSystem sol = new AutocompleteSystem(s, times);
        System.out.println(sol.input('i'));
        System.out.println(sol.input(' '));
        System.out.println(sol.input('a'));
    }

    static class Pair {
        String s;
        int times;
        Pair(String s, int times){
            this.s = s;
            this.times = times;
        }
    }
    static class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
        Map<String, Integer> times = new HashMap<>();
    }
}
