#include <stdio.h>
#include <stdlib.h>
#include <string.h>
char* insert_str(char *str1, int len)
{
        int spacenum = 0;
        int i = 0;
        for(i = 0; i < len; i++)
        {
                if(str1[i] == ' ')
                {
                        spacenum++;
                }
        }
        char str2[len+spacenum * 2];
        int j = 0;
        for(i = 0, j =0; i < len; i++, j++ )
        {
                if(str1[i] == ' ')
                {
                        str2[j] = '%';
                        str2[j+1] = '2';
                        str2[j+2] = '0';
                        j = j + 2;
                }
                else
                str2[j] = str1[i];
        }
        return str2;


}
int main()
{
//        char *str1;
//        str1 = (char *)malloc(1024);
//        char *str2;
//        str2 = (char *)malloc(1024);
//        bzero(str2, 1024);
//        int n1 = read(0, str1, 1024);
//        printf("%s", str1);
        char str1[5] = {'I', ' ', 'm', ' ', 'u'};
        char str2[10] = {'I', ' ', 'l','o','v','e', ' ', 'y','o','u'};
        printf("RESULT %s\n", insert_str(str1, 5));
        printf("RESULT %s\n", insert_str(str2, 10));
;

}


