import java.util.*;

public class Solution3 {

	public boolean isValid(String s) {
		Map<String, String> map = new HashMap<>();
		map.put(")", "(");
		map.put("}", "{");
		map.put("]", "[");

		Stack<String> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(Character.toString(c));
			} else {
				String cs = Character.toString(c);
				String st = stack.isEmpty() ? null : stack.peek();
				if (map.get(cs).equals(st)) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String args[]) {
		Solution3 sol = new Solution3();
	}
}
