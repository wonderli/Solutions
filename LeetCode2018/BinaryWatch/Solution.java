import java.util.*;

public class Solution {
	public List<String> readBinaryWatch(int num) {
		if (num > 10)
			return null;
		List<Pair> hmList = getHm(num);
		List<String> res = new ArrayList<>();
		for (Pair p : hmList) {
			List<List<Integer>> hourList = getHour(p.first);
			List<List<Integer>> minutesList = getMinutes(p.second);
			List<String> currRes = cross(hourList, minutesList);
			res.addAll(currRes);
		}
        Collections.sort(res);
		return res;
	}

	public List<List<Integer>> getHour(int num) {
		int[] arr = { 8, 4, 2, 1 };
		return getArray(arr, num);
	}

	public List<List<Integer>> getMinutes(int num) {
		int[] arr = { 32, 16, 8, 4, 2, 1 };
		return getArray(arr, num);
	}

	public List<List<Integer>> getArray(int[] nums, int num) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> curr = new ArrayList<>();
		helper(0, num, nums, res, curr);
		return res;
	}

	public void helper(int index, int num, int[] nums, List<List<Integer>> res, List<Integer> curr) {
		if (curr.size() == num) {
			res.add(curr);
			return;
		}
		for (int i = index; i < nums.length; i++) {
			List<Integer> tmp = new ArrayList<>(curr);
			curr.add(nums[i]);
			helper(i + 1, num, nums, res, curr);
			curr = tmp;
		}
	}

	public List<String> cross(List<List<Integer>> hour, List<List<Integer>> minute) {
		List<String> hourList = getTextList(hour, true);
		List<String> minuteList = getTextList(minute, false);
		List<String> res = new ArrayList<>();

			for (String h : hourList) {
				for (String m : minuteList) {
					String a = String.format("%s:%s", h, m);
					res.add(a);
				}
			}
		
		return res;
	}

	public List<String> getTextList(List<List<Integer>> list, boolean isHour) {
		List<String> res = new ArrayList<>();
		for (List<Integer> e : list) {
			int num = 0;
			for (Integer i : e) {
				num += i;
			}
            
            if(num >= 12&& isHour) {
				continue;
			}
			if(num > 59 && !isHour) {
				continue;
            }

			String curr = Integer.toString(num);
			if (isHour) {
				res.add(curr);
			} else {
				String s = String.format("%02d", num);
				res.add(s);
			}
		}
		return res;
	}

	public List<Pair> getHm(int num) {
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i <= num && i <= 4; i++) {
			Pair p = new Pair(i, num - i);
			list.add(p);
		}
		return list;
	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		int num = 1;
		List<String> s = sol.readBinaryWatch(num);
		for (String e : s) {
			System.out.println(e);
		}
	}
}

class Pair {
	int first;
	int second;

	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return String.format("First: %d, Second: %d", first, second);
	}
}


