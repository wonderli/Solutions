import java.util.*;
public class Sol{
    public static void move(int array[]){
        int begin = 0;
        int end = array.length - 1;
        while(begin < end){
            if((array[begin]&1) != 0){
                begin++;
                continue;
            }
            if((array[end]&1) == 0){
                end--;
                continue;
            }
            int tmp = array[begin];
            array[begin] = array[end];
            array[end] = tmp;
        }
    }
    public static void main(String args[]){
        int size = 20;
        int array[] = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = i;
        }
        move(array);
        System.out.println(Arrays.toString(array));

    }

}
