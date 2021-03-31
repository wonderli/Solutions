#include <stdio.h>
#include <stdlib.h>
void reverse(char *str)
{
        int i = 0;
        while((*str)!=NULL)
        {
                i++;
                str++;
        }
        printf("length %d\n", i);
        char x;
        int j = 0;
        for(j = 0; j < i/2; j++)
        {
                x = *(str - j - 1);
                *(str - j - 1) = *(str - i - 1 +j);
                *(str -i - 1 + j) = x;
        }

}
void testStr(int* array)
{
        int i = 0;
        array[8] = 1222;
        *(array) = 3333;
        for(i = 0; i < 10; i++)
        {
                printf("%d\n", *array);
                array++;
        }
}

int main()
{
        char *str;
        str = (char *)malloc(1024);
        int nread = read(0, str, 1024);
        printf("ORIGINAL str is %s", str);
        reverse(str);
        printf("After reverse str is %s", str);
}







