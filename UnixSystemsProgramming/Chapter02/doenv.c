//Exercise 2.12
//An env utility
//P54
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <limits.h>
#include <string.h>
#define FALSE 0
#define TRUE 1
extern char **environ;
void print_env(){
    int i = 0;
    while(environ[i]){
        printf("%s\n", environ[i++]);
    }
}
void set_env(char **new_env){
    char *name;
    char *value;
    name = (char *) malloc(sizeof(char) * 20);
    value = (char *) malloc(sizeof(char) * MAX_CANON);
    while(*new_env != NULL){
        char *tmp = strchr(*new_env, '=');
        strncpy(name, *new_env, tmp - *new_env);
        strcpy(value, tmp + 1);
        if(getenv(name) != NULL){
            setenv(name, value, 1);
        }else{
            setenv(name, value, 0);
        }
        new_env++;
    }
}

int main(int argc, char **argv){
    char **my_environ;
    int i_flag = FALSE; 
    opterr = 0;
    int ch;
    my_environ = (char **)malloc(sizeof(char *) * argc);
    char *cmd = NULL;
    while((ch = getopt(argc, argv, "i")) != -1){
        switch(ch){
            case 'i':
                i_flag = TRUE;
                break;
            default:
                break;
        }
    }
    int index = 0;
    int count = 0;
    for(index = optind; index < argc; index++){
        if(strchr(argv[index], '=') != NULL){
            my_environ[count] = argv[index];
            count++;
        }else{
            cmd = argv[index];
        }
    }
    my_environ[count] = NULL;
    if((i_flag == FALSE) && (cmd == NULL)){
        print_env();
    }else{
        set_env(my_environ);
        print_env();
    }
    if(system(cmd) < 0){
        perror("Failed to execute");
    }
    return 0;
}

