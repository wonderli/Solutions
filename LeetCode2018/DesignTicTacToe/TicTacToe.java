public class TicTacToe {

	int[] rows;
	int[] cols;
	int diagonal;
	int antiDiagonal;
	int size;

	public TicTacToe(int n) {
		rows = new int[n];
		cols = new int[n];
		diagonal = 0;
		diagonal = 0;
		size = n;
	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row    The row of the board.
	 * @param col    The column of the board.
	 * @param player The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move(int row, int col, int player) {
		if (check(row, col, player)) {
			return player;
		}
		return 0;

	}

	private boolean check(int row, int col, int player) {
		int offset = player == 1 ? 1 : -1;
		rows[row] += offset;
		cols[col] += offset;
		if (row == col) {
			diagonal += offset;
		}
		if (row + col == size - 1) {
			antiDiagonal += offset;
		}
		int m = size * offset;
		return (rows[row] == m || cols[col] == m || diagonal == m || antiDiagonal == m);
	}
}

/**
 * Your TicTacToe object will be instantiated and called as such: TicTacToe obj
 * = new TicTacToe(n); int param_1 = obj.move(row,col,player);
 */