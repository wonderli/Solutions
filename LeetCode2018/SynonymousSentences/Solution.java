import java.util.*;

public class Solution {
	List<Set<String>> draftSets = new ArrayList<>();
	Map<String, Integer> synonymLookup = new HashMap<>();
	Set<String> result = new HashSet<>();

	public List<String> generateSentences(List<List<String>> synonyms, String text) {
		// Merge them all
		boolean added = false;
		for (List<String> synonym : synonyms) {
			for (Set<String> currSet : draftSets) {
				if (currSet.contains(synonym.get(0)) || currSet.contains(synonym.get(1))) {
					currSet.add(synonym.get(0));
					currSet.add(synonym.get(1));
					added = true;
					break;
				}
			}
			if (!added) {
				Set<String> newSet = new HashSet<>();
				newSet.add(synonym.get(0));
				newSet.add(synonym.get(1));
				draftSets.add(newSet);
			}
		}

		// Mark them with index
		for (int i = 0; i < draftSets.size(); i++) {
			for (String synonym : draftSets.get(i)) {
				synonymLookup.put(synonym, i);
			}
		}
		
		String[] tArr = text.split(" ");
		helper(0, tArr.length, tArr);
		List<String> res = new ArrayList<>(result);
		Collections.sort(res);
		return res;
	}

	private void helper(int index, int len, String[] tArr) {
		if(index >=  len) {
			result.add(String.join(" ", tArr));
			return;
		}
		for(int i = index; i < len; i++){
			if(synonymLookup.containsKey(tArr[i])) {
				Integer setIndex = synonymLookup.get(tArr[i]);
				for(String draft : draftSets.get(setIndex)) {
					tArr[i] = draft;
					helper(i + 1, len, tArr);
				}
			}
			if(i == len - 1) {
				result.add(String.join(" ", tArr));
			}
			
		}
	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		List<List<String>> ss = new ArrayList<>();
		List<String> s1 = Arrays.asList("happy", "joy");
		List<String> s2 = Arrays.asList("sad", "sorrow");
		List<String> s3 = Arrays.asList("joy", "cheerful");
		List<String> s4 = Arrays.asList("yo", "cheerful");
		List<String> s5 = Arrays.asList("happy", "cheer");
		ss.add(s1);
		ss.add(s2);
		ss.add(s3);
		ss.add(s4);
		ss.add(s5);
		String text = "I am happy today but was sad yesterday";
		System.out.println(sol.generateSentences(ss, text));
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
