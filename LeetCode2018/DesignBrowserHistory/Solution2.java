import java.util.*;
public class Solution2{
	private class BrowserHistory {

		Map<Integer, String> map;
		int curr = 0;
		int max = 0;
		public BrowserHistory(String homepage) {
			map = new HashMap<>();
			map.put(curr, homepage);
		}
    
		public void visit(String url) {
			curr++;
			map.put(curr, url);
			max = curr;
		}
    
		public String back(int steps) {
			curr = Math.max(0, curr -steps);
        
			return map.get(curr);
		}
    
		public String forward(int steps) {
			curr = Math.min(max, curr + steps);
			return map.get(curr);
		}
	}

	public static void main(String args[]){
		Solution2 sol = new Solution2();
	}
}