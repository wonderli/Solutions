import java.util.*;
public class Solution {
	private Set<Character> set = new HashSet<>();
	{
		set.add('!');
		set.add('?');
		set.add('\'');
		set.add(',');
		set.add(';');
		set.add('.');
		set.add(' ');
	}
	public String mostCommonWord(String paragraph, String[] banned) {
		List<String> ss = split(paragraph);
		Map<String, Integer> map = new HashMap<>();
		Set<String> bannedSet = new HashSet<>();
		for(String e : banned){
			bannedSet.add(e);
		}
		String result = null;
		int max = 0;
		for(String e : ss){
			if(!bannedSet.contains(e)){
				map.put(e, map.getOrDefault(e, 0) +1);    
			}
			if(map.getOrDefault(e, 0) > max){
				max = map.get(e);
				result = e;
			}
		}
        
		return result;
	}
    
	private List<String> split(String s){
		s = s.toLowerCase();
		int n = s.length();
		int i = 0;
		int j = 0;
		List<String> result = new ArrayList<>();
		while(j < n){
			while(j < n && !isPunctions(s.charAt(j))){
				j++;
			}
			String sub = s.substring(i, j);
			result.add(sub);
			i = j;
			while(j < n && isPunctions(s.charAt(i))){
				i++;
				j++;
			}
		}
		return result;
	}
	private boolean isPunctions(char c){
		return set.contains(c);
	}
}