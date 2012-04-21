#include <stdio.h>
#include <string.h>
#include <stdlib.h>
void print_string(char **s, int size) {
    int i = 0;
    printf("***********************************\n");
    for(i = 0; i < size; i++) {
        printf("%s\n", *(s + i));
    }
    printf("***********************************\n");

}
int compare(const void *a, const void *b){
    if(*(char *)a > *(char *)b) 
        return 1;
    else
        return -1;
}
void anagram_sort(char **s, char **new_s, int size) {
    int i = 0;
    for(i = 0; i < size; i++) {
        qsort(*(s + i), strlen(*(s + i)), sizeof(char), compare);
        printf("%s\n", *(s + i));
    }
    int j = 0;
    int k = 0;
    int del[size];
    for(i = 0; i < size; i++)
        del[i] = 0;

    for(i = 0; i < size - 1; i++) {
        if(del[i] == 0) {
            del[i] = 1;
            strcpy(*(new_s + k), *(s + i));
            k++;
            for(j = i + 1; j < size; j++) {
                if(strcmp(*(s + i), *(s + j)) == 0) {
                    strcpy(*(new_s + k), *(s + j));
                    k++;
                    del[j] = 1; 
                }
            }
        } else {
            continue;
        }
    }


}

int main() {
    char **s;
    s = (char**)malloc(1024);
    char **new_s;
    new_s = (char**)malloc(1024);

    int i = 0;
    for(i = 0; i < 1024; i++) {
        *(s + i) = (char *)malloc(1024);
        *(new_s + i) = (char *)malloc(1024);
    }
    int size = 7;
    strcpy(*(s + 0), "hello");
    strcpy(*(s + 1), "world");
    strcpy(*(s + 2), "dlrow");
    strcpy(*(s + 3), "drlow");
    strcpy(*(s + 4), "olleh");
    strcpy(*(s + 5), "man");
    strcpy(*(s + 6), "nam");
    print_string(s, size);
    anagram_sort(s, new_s, size);
    print_string(new_s, size);
}
