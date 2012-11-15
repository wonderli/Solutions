#include <stdio.h>
#include <sys/time.h>
#include <stdlib.h>
#include <math.h>
int timeval_subtract(struct timeval *result, struct timeval *t2, struct timeval *t1){
    long int diff = (t2->tv_usec + 1000000 * t2->tv_sec) - (t1->tv_usec + 1000000 * t1->tv_sec);
    result->tv_sec = diff / 1000000;
    result->tv_usec = diff % 1000000;
    return (diff < 0);
}
int main(int argc, char *argv[]){
    int i = 0;
    time_t curtime;
    struct timeval tvBegin;
    struct timeval tvEnd;
    struct timeval tvDiff;

    gettimeofday(&tvBegin, NULL);
    if(argc < 2){
        printf("Default to 50%% CPU\n");
        while(1){
            while(1){
                gettimeofday(&tvEnd, NULL);
                timeval_subtract(&tvDiff, &tvEnd, &tvBegin);
                //printf("%ld, %ld\n", tvDiff.tv_sec,tvDiff.tv_usec);
                if(tvDiff.tv_usec > 11000){
                    break;
                }
            }
            usleep(10000);
            gettimeofday(&tvBegin, NULL);
        }
    }
    //printf("%s\n", argv[1]);
    return 0;
}
