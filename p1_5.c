#include <stdio.h>
#include <stdlib.h>
#include <string.h>
char* count_repeat(char *str1, char *str2)
{
        int len = strlen(str1);
        int i = 0;
        char last = *str1;
        int j = 0;
        int count = 1;
        for(i = 1, j = 0; i < len; i++)
        {
                if(*(str1+i) == *(str1 + i -1))
                {
                        count++;
                }
                else
                {
                        *(str2 + j) = last;
                        j++;
                        *(str2 + j) = '0' + count;
                        j++;
                        count = 1;
                        last = *(str1 + i);
                }
        }
        *(str2 + j) = last;
        *(str2 + j + 1) = count + '0';
//        *(str2 + j + 2) = '\0';
        
        if(strlen(str1) <= strlen(str2))
                return str1;

        return str2;
}
int main()
{
        char *str1 = "abbbccccxx";
        char *str2;
        str2 = (char*)malloc(1024);
        bzero(str2, 1024);
        str2 = count_repeat(str1, str2);
        printf("%s\n", str2);

}
