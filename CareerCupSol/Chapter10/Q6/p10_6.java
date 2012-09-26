public class p10_6 {
	/* The origin is matrix start point, in another words, matrix uppder-left point
	 * The dest is matrix finish point, in another words, matrix bottom-right point
	 * */
	public Coordinate findElement(int[][] matrix, Coordinate origin, Coordinate dest, int x) {
		if(!origin.inBound(matrix) || dest.inBound(matrix))
			return null;
		//find the element
		if(matrix[origin.row][origin.column] == x){
			return origin;
		}
		//Check the start point wheter before the end point or not
		else if(!origin.isBefore(dest)) {
			return null;
		}
		Coordinate start = (Coordinate) origin.clone();
		int diagDist = Math.min(dest.row - origin.row, dest.column - origin.column);
		Coordinate end = new Coordinate(start.row + diagDist, start.column + diagDist);
		Coordinate p = new Coordinate(0, 0);
		while(start.isBefore(end)) {
			p.setToAverage(start, end);//Get the mid of row and column
			if(x > matrix[p.row][p.column]) {
				start.row = p.row + 1;
				start.column = p.column + 1;
			} else {
				end.row = p.row - 1;
				end.column = p.column - 1;
			}
		}
		return partitionAndSearch(matrix, origin, dest, start, x);
	}
	public Coordinate partitionAndSearch(int[][] matrix, Coordinate origin, Coordinate dest, Coordinate pivot, int elem) {
		Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.column);
		Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.column - 1);
		Coordinate upperRightOrgin = new Coordinate(origin.row, pivot.column);
		Coordinate upperRightDest = new Coordinate(pivot.row - 1, dest.column);
		Coordinate lowerLeft = findElement(matrix, lowerLeftOrigin, lowerLeftDest, elem);
		if(lowerLeft == null) {
			return findElement(matrix, upperRightOrgin, upperRightDest, elem);
		}
		return lowerLeft;
	}
	public Coordinate findElement(int[][] matrix, int x) {
		Coordinate origin = new Coordinate(0, 0);
		Coordinate dest = new Coordinate(matrix.length - 1, matrix[0].length - 1);
		return findElement(matrix, origin, dest, x);
	}
	public static void main(String[] args) {
		int M = 20;
		int N = 20;
		int key = 10;
		int[][] matrix = new int[M][N];
		int count = 0;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				matrix[i][j] = count;
				System.out.print(count + " ");
				count++;
			}
			System.out.println();
		}
		p10_6 p = new p10_6();
		Coordinate c = p.findElement(matrix, key);
		System.out.println("Key: " + key + "Coordinate Row: " + c.row + "Coordinate Column " + c.column);
	}
}
