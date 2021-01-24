import java.util.*;
public class Solution2 {
	int m;
	int n;
	public int[][] diagonalSort(int[][] mat) {
		m = mat.length;
		if(m == 0) return mat;
		n = mat[0].length;
		for(int i = m - 1; i >= 0; i--){
			List<Integer> list = get(mat, i, 0);
			Collections.sort(list);
			set(mat, list, i, 0);
		}
        
		for(int j = 1; j < n; j++){
			List<Integer> list = get(mat, 0, j);
			Collections.sort(list);
			set(mat, list, 0, j);
		}
		return mat;
	}
	private List<Integer> get(int[][] mat, int x, int y){
		List<Integer> result = new ArrayList<>();
		int i = x;
		int j = y;
		while(i < m && j < n){
			result.add(mat[i][j]);
			i++;
			j++;
		}
        
		return result;
	}
    
	private void set(int[][] mat, List<Integer> list, int x, int y){
		int i = x;
		int j = y;
		int k = 0;
		while(i < m && j < n && k < list.size()){
			mat[i][j] = list.get(k);
			k++;
			i++;
			j++;
		}
        
        
		// print(mat);
	}
	private void print(int[][] mat){
		for(int[] e : mat){
			System.out.println(Arrays.toString(e));
		}
	}
}
