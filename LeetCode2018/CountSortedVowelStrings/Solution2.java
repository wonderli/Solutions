public class Solution2 {
	// C((n+k-1), k)
	public int countVowelStrings(int n) {
		return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
	}
} 
