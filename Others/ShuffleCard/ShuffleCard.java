import java.util.Random;
import java.util.Arrays;
public class ShuffleCard{
    public static void shuffleCard(int array[]){
        int len = array.length;
        Random r = new Random();
        int i = len - 1;
        int j = 0;
        int temp = 0;
        while(i > 0){
            j = Math.abs(r.nextInt(i));
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i--;
        }
    }
    public static void printArray(int array[]){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int array[] = new int[54];
        int i = 0;
        Random r = new Random();
        while(i < array.length){
            array[i] = r.nextInt(100)%array.length;
            i++;
        }
        printArray(array);
        Arrays.sort(array);
        printArray(array);
        shuffleCard(array);
        printArray(array);
        Arrays.sort(array);
        printArray(array);
         
    }
}
