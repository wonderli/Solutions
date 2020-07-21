import java.util.*;

public class Solution {
	public boolean backspaceCompare(String S, String T) {
		int i = S.length() - 1;
		int j = T.length() -1;
		while(i >= 0 || j >= 0) {
			int pos1 = getNext(S, i);
			int pos2 = getNext(T, j);
			if(pos1 < 0 && pos2 < 0) {
				return true;
			}
			
			if(pos1 < 0 || pos2 < 0) {
				return false;
			}
			char a = S.charAt(pos1);
			char b = T.charAt(pos2);
			if(a != b) return false;
			i = pos1 - 1;
			j = pos2 - 1;
		}
		
		return true;
	}

	private int getNext(String s, int i) {
		int backspace = 0;
		while(i >= 0) {
			if(s.charAt(i) == '#') {
				backspace++;
			}else if(backspace > 0){
				backspace--;
			}else {
				break;
			}
			i--;
		}
		return i;
		
	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		String s = "ab##";
		String t = "c#d#";
		System.out.println(sol.backspaceCompare(s, t));

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
