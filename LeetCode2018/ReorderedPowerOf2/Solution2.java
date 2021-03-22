import java.util.*;
class Solution {
	private static Set<String> set = build();
	
    public boolean reorderedPowerOf2(int N) {

        String n = Integer.toString(N);
        char[] cs = n.toCharArray();
        Arrays.sort(cs);
        return set.contains(new String(cs));
        
    }
    private static Set<String> build(){
        Set<String> set = new HashSet<>();
        int n = 1;
        // set.add(Integer.toString(n));
        for(int i = 0; i < 31; i++){
            String s = Integer.toString(n);
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            set.add(new String(cs));
            n = n << 1;
        }
        return set;
    }
}
