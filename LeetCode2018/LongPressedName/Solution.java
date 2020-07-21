import java.util.*;

public class Solution {
	public boolean isLongPressedName(String name, String typed) {
		int nameIndex = 0;
		for (int i = 0; i < typed.length(); i++) {
			if (nameIndex < name.length() && typed.charAt(i) == name.charAt(nameIndex)) {
				nameIndex++;
			} else if (i > 0 && typed.charAt(i) == typed.charAt(i - 1)) {
				continue;
			} else
				return false;
		}
		return nameIndex == name.length();
	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		System.out.println(sol.isLongPressedName("alex", "aaleex"));
		System.out.println(sol.isLongPressedName("leelee", "lleeelee"));
		System.out.println(sol.isLongPressedName("laiden", "laiden"));
		System.out.println(sol.isLongPressedName("saeed", "ssaaedd"));
	}

}
