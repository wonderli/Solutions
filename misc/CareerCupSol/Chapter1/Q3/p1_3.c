#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define TRUE 1
#define FALSE 0
int check_permutation(char *str1, char *str2)
{
        int set1[256];
        int set2[256];
        int i = 0;
        unsigned char tmp1;
        unsigned char tmp2;
        for(i = 0; i < 256; i++)
        {
                set1[i] = 0;
                set2[i] = 0;
        }

        while(*str1 != NULL)
        {
                tmp1 = str1;
                set1[atoi(&tmp1)] += 1;
                str1++;
        }

        while(*str2 != NULL)
        {
                tmp2 = str2;
                set2[atoi(&tmp2)] += 1;
                str2++;
        }

        for(i = 0; i < 256; i++)
        {
               if(set2[i] != set1[i])
                {
                        return FALSE;
                }
        }
        return TRUE;
}
int main()
{
        char* str1 = "012345";
        char* str2 = "543210";
        printf("%d\n", check_permutation(str1, str2));
}
