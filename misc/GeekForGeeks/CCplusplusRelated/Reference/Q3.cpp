#include<iostream>
using namespace std;

void swap(char * &str1, char * &str2)
//void swap(char * str1, char * str2)
{
    char *temp = str1;
    str1 = str2;
    str2 = temp;
}

int main()
{
    char *str1 = "GEEKS";
    char *str2 = "FOR GEEKS";
    cout<<"str1 is "<<str1<<endl;
    cout<<"str2 is "<<str2<<endl;
    swap(str1, str2);
    cout<<"str1 is "<<str1<<endl;
    cout<<"str2 is "<<str2<<endl;
    return 0;
}
