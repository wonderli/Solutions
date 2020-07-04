import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Solution sol = new Solution();
		WordDictionary w = new WordDictionary();
		w.addWord("at");
		w.addWord("and");
		w.addWord("an");
		w.addWord("add");

		System.out.println(w.search("a"));
		System.out.println(w.search(".at"));
		w.addWord("bat");
		System.out.println(w.search(".at"));
		System.out.println(w.search("an."));
	}
}

class WordDictionary {
	Node root;

	/** Initialize your data structure here. */
	public WordDictionary() {
		root = new Node('0', false);
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		if (word == null)
			return;
		char[] arr = word.toCharArray();
		Node curr = root;
		Node prev = null;
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if (curr.get(c) == null) {
				curr.put(c, new Node(c, false));
			}
			prev = curr;
			curr = curr.get(c);
		}
		prev.get(arr[arr.length - 1]).isEnd = true;
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		if (word == null) {
			return false;
		}
		return search(root, word, 0);
	}

	private boolean search(Node curr, String word, int index) {
		if (index >= word.length())
			return false;
		char c = word.charAt(index);
		Node n = curr.get(c);
		if (c != '.' && n == null) {
			return false;
		}
		if (index == word.length() - 1) {
			if (c == '.') {
				Map<Character, Node> map = curr.map;
				for (Node next : map.values()) {
					if (next.isEnd) {
						return true;
					}
				}
				return false;

			} else if (n.c == c && n.isEnd) {
				return true;
			}

		}

		if (c != '.') {
			if (n.c == c) {
				return search(n, word, index + 1);
			}
		} else {
			Map<Character, Node> map = curr.map;
			for (Node next : map.values()) {
				if (search(next, word, index + 1)) {
					return true;
				}
			}
		}
		return false;

	}

	class Node {
		char c;
		boolean isEnd;
		Map<Character, Node> map;

		Node(char c, boolean isEnd) {
			this.c = c;
			this.map = new HashMap<>();
			this.isEnd = isEnd;
		}

		void put(char c, Node n) {
			map.put(c, n);
		}

		Node get(char c) {
			return map != null ? map.get(c) : null;
		}

		@Override
		public String toString() {
			return String.format("c : %s isEnd : %b\n Map Keys: %s Map Values: %s\n", c, isEnd, map.keySet(),
					map.values());

		}

	}
}
