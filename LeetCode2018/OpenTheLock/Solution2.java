import java.util.*;

public class Solution2 {
	public int openLock(String[] deadends, String target) {
		Set<String> dead = new HashSet<>(Arrays.asList(deadends));
		Queue<String> queue = new LinkedList<>();
		Set<String> seen = new HashSet<>();
		if (!dead.contains("0000")) {
			queue.offer("0000");
			seen.add("0000");
		}
		int layer = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String curr = queue.poll();
				if (curr.equals(target)) {
					return layer;
				}

				for (String adj : getAdj(curr)) {
					if (!dead.contains(adj) && !seen.contains(adj)) {
						queue.offer(adj);
						seen.add(adj);
					}
				}
			}
			layer++;
		}
		return -1;
	}

	private List<String> getAdj(String curr) {
		List<String> ret = new ArrayList<>();
		for (int i = 0; i < curr.length(); i++) {
			int v = Character.getNumericValue(curr.charAt(i));
			ret.add(build(v + 1 > 9 ? 0 : v + 1, curr, i));
			ret.add(build(v - 1 < 0 ? 9 : v - 1, curr, i));
		}
		return ret;
	}

	private String build(int v, String curr, int i) {
		StringBuilder sb = new StringBuilder(curr);
		sb.setCharAt(i, (char) (v + '0'));
		return sb.toString();
	}

	public static void main(String args[]) {
		Solution2 sol = new Solution2();
	}
}

