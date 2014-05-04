#include <stdio.h>
#include <signal.h>
#include <unistd.h>
//typedef void (*sig_handler)(int);
void fun(int signo){
    printf("Catch signal number %d", signo);
}
int main(){
    signal(SIGINT, fun);
    sleep(30);
}

