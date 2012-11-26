#include <stdio.h>
#define TRUE 1
#define FALSE 0
#define N 4
void printSol(int sol[N][N]){
    int i = 0;
    int j = 0;
    for(i = 0; i < N; i++){
        for(j = 0; j < N; j++){
            printf("%d ", sol[i][j]);
        }
        printf("\n");
    }
}
int isSafe(int board[N][N], int row, int col){
    int i = 0;
    int j = 0;
    for(i = 0; i < col; i++){
        if(board[row][i] == 1){
            return FALSE;
        }
    }
    for(i = row, j = col; i >= 0 && j >= 0; i--, j--){
        if(board[i][j] == 1){
            return FALSE;
        }
    }
    for(i = row, j = col; i < N && j >= 0; i++, j--){
        if(board[i][j] == 1){
            return FALSE;
        }
    }
    return TRUE;
}
int solveHelper(int board[N][N], int col){
    if(col >= N){
        return TRUE;
    }
    int i = 0;
    for(i = 0; i < N; i++){
        if(isSafe(board, i, col) == TRUE){
            board[i][col] = 1;
            if(solveHelper(board, col+1) == TRUE){
                return TRUE;
            }
            board[i][col] = 0;
        }
    }
    return FALSE;
}
int solve(){
    int board[N][N];
    int i = 0;
    int j = 0;
    for(i = 0; i < N; i++){
        for(j = 0; j < N; j++){
            board[i][j] = 0;
        }
    }
    if(solveHelper(board, 0) == FALSE){
        printf("Solution does not exists!");
        return FALSE;
    }
    printSol(board);
    return TRUE;

}
int main(){
    solve();
}
