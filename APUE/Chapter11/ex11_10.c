#include <stdlib.h>
#include <pthread.h>
struct foo{
    int f_count;
    pthread_mutex_t f_lock;
};
struct foo *foo_alloc(void){
    struct foo *fp;
    if((fp = malloc(sizeof(struct foo))) != NULL){
        fp->f_count = 1;
        if(pthread_mutex_init(&fp->f_lock, NULL) != 0){
            free(fp);
            return (NULL);
        }
    }
    return (fp);
}
void foo_hold(struct foo *fp){
    pthread_mutex_lock(&fp->f_lock);
    fp->f_count++;
    pthread_mutex_unlock(&fp->f_lock);
}
void foo_rele(struct foo *fp){
    pthread_mutex_lock(&fp->f_lock);
    if(--fp->f_count == 0){
        pthread_mutex_unlock(&fp->f_lock);
        pthread_mutex_destroy(&fp->f_lock);
        free(fp);
    }else{
        pthread_mutex_unlock(&fp->f_lock);
    }
}
void *fun1(struct foo *fp){
    printf("thead1 start\n");
    printf("fun1 %d\n", fp->f_count);
    foo_hold(fp);
    printf("fun1 %d\n", fp->f_count);
    foo_rele(fp);
    pthread_exit((void *)1);

}
void *fun2(struct foo *fp){
    printf("thead2 start\n");
    foo_hold(fp);
    printf("fun2 %d\n", fp->f_count);
    foo_rele(fp);
    pthread_exit((void *)1);
}

int main(){
    struct foo *ptr = foo_alloc();
    pthread_t tid1, tid2;
    int err;
    printf("Main %d\n", ptr->f_count);
    sleep(2);
    err = pthread_create(&tid1, NULL, fun1, &ptr);
    if(err != 0){
        printf("error\n");
    }
    sleep(2);
    err = pthread_create(&tid2, NULL, fun2, &ptr);
    if(err != 0){
        printf("error\n");
    }
    printf("Main %d\n", ptr->f_count);
    return 0;
}
