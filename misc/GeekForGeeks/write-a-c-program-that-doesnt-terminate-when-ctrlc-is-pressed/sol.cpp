#include <iostream>
#include <csignal>
void signalHandler(int signum){
    //signal(SIGINT, signalHandler);
    printf("can't be terminated by ctrl + c");
    fflush(stdout);
}
int main(){
    signal(SIGINT, signalHandler);
    while(1){
    }
}
