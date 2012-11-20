#include <stdio.h>
int main(){
    printf("Enter the number, 0 is end\n");
    int input = 0;
    scanf("%d", &input);
    int max[3];
    int count = 0;
    int temp = 0;
    int sum = 0;
    int i = 0;
    while(input!=0){
        //printf("%d\n", input);
        count++;
        if(count <= 3){
            max[count - 1] = input;
        }else{
            for(i = 0; i < 3; i++){
                if(input > max[i]){
                    temp = max[i];
                    max[i] = input;
                    input = temp;
                }
            }
            sum = sum + input;
        }
        scanf("%d", &input);
    }
    //printf("max[0] %d max[1] %d max[2] %d", max[0], max[1], max[2]);
    count = count - 3;
    float average = sum / count;
    printf("average number is %f, sum %d, count %d", average, sum, count);
}
