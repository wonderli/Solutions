#include <stdio.h>
#define N 4
#define TRUE 1
#define FALSE 0
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
int isSafe(int maze[N][N], int i, int j){
    if(i >= 0 && i < N && j >= 0 && j < N && maze[i][j] == 1){
        return TRUE;
    }else return FALSE;
}
int solveHelper(int maze[N][N], int i, int j, int sol[N][N]){
    if(i == N-1 && j == N-1){
        sol[i][j] = 1;
        return TRUE;
    }
    if(isSafe(maze, i, j) == TRUE){
        sol[i][j] = 1;
        if(solveHelper(maze, i+1, j, sol) == TRUE){
            return TRUE;
        }
        if(solveHelper(maze, i, j+1, sol) == TRUE){
            return TRUE;
        }
        sol[i][j] = 0;
        return FALSE;
    }
    return FALSE;
}
int solve(int maze[N][N]){
    int sol[N][N];
    int i = 0; 
    int j = 0;
    for(i = 0; i < N; i++){
        for(j = 0; j < N; j++){
            sol[i][j] = 0;
        }
    }
    if(solveHelper(maze, 0, 0, sol) == FALSE){
        printf("The solution doesn't exists!");
        return FALSE;
    }
    printSol(sol);
    return TRUE;
}
int main(){
    int maze[N][N] = {
        {1, 0, 0, 0},
        {1, 1, 0, 1},
        {0, 1, 0, 0},
        {1, 1, 1, 1}
    };
    solve(maze);
     
}

