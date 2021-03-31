//小米笔试，给一个浮点数序列，取最大乘积连续子串的值，例如 -2.5，4，0，3，0.5，8，-1，则取出的最大乘积连续子串为3，0.5，8。也就是说，上述数组中，3 0.5 8这3个数的乘积3*0.5*8是最大的，而且是连续的。
public class Sol{
    public static float max(float x, float y, float z){
        float tmp = x > y ? x : y;
        return tmp > z ? tmp : z;
    }
    public static float min(float x, float y, float z){
        float tmp = x < y ? x : y;
        return tmp < z ? tmp : z;
    }

    public static void maxMultipleSubstring(float array[]){
        float maxArray[] = new float[array.length + 1]; 
        float minArray[] = new float[array.length + 1];
        float r[] = new float[array.length +1];
        for(int i = 0; i < r.length; i++){
            r[i] = -1;
        }
        maxArray[1] = array[1];
        minArray[1] = array[1];
        r[1] = array[1];
        float maxValue = maxArray[1];
        for(int i = 2; i < r.length - 1; i++){
            maxArray[i] = max(maxArray[i-1] * array[i], minArray[i-1]*array[i], array[i]);
            minArray[i] = min(maxArray[i-1] * array[i], minArray[i-1]*array[i], array[i]);
            if(maxArray[i] > maxValue){
                maxValue = maxArray[i];
            }
        }
        if(maxValue < 0) System.out.println(-1);
        else System.out.println(maxValue);
    }
    public static void main(String args[]){
        float array[] = {-2.5f, 4, 0, 3, 0.5f, 8, -1};
        maxMultipleSubstring(array);
    }
}
