import java.util.*;
public class WordDistance {
	public Map<String, List<Integer>> map = new HashMap<>();
	public WordDistance(String[] words) {
		for(int i = 0; i <words.length; i++){
			String s = words[i];
			List<Integer> list;
			if(map.containsKey(s)){
				list = map.get(s);
			}else{
				list = new ArrayList<Integer>();
			}
			list.add(i);
			map.put(s, list);
		}

	}
	public int shortest(String word1, String word2) {
		int min = Integer.MAX_VALUE;
		List<Integer> l1 = map.get(word1);
		List<Integer> l2 = map.get(word2);
		for(int l1e : l1){
			for(int l2e : l2){
				min = Math.min(Math.abs(l1e - l2e), min);
			}
		}
		return min;

	}


}
