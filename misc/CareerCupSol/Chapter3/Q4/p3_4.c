#include <stdio.h>
void move(int n, char x, char y) {
    printf("Move %d from %c to from %c\n", n, x, y);
}

void moveDisk(int n, char src, char buf, char des) {
    if(n == 1)
        move(1, src, des);
    else {
        moveDisk(n-1, src, des, buf);
        move(n, src, des);
        moveDisk(n-1, buf, src, des);
    }

}
int main() {
    int n;
    scanf("%d", &n);
    moveDisk(n, 'a', 'b', 'c');

}
