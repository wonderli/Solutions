public class Sol{
    public static void findNum(int array[]){
        int len = array.length;
        int xorResult = 0;
        for(int i = 0; i < len; i++){
            xorResult ^= array[i];
        }
        int num1 = 0;
        int num2 = 0;
        int index = findFirstBit(xorResult);
        for(int i = 0; i < len; i++){
            if(isBit1(array[i], index)){
                num1 ^= array[i];
            }else {
                num2 ^= array[i];
            }
        }
        System.out.println(num1);
        System.out.println(num2);

    }
    public static int findFirstBit(int num){
        int r = 0;
        int one = 1;
        while(true){
            if((num & one) == 0){
                one = one << 1;
                r++;
                continue;
            }else{
                break;
            }
        }
        return r;
    }
    public static boolean isBit1(int num, int index){
        int one = 1 << index;
        if((num & one) == 0){
            return false;
        }else return true;
    }
    public static void main(String args[]){
        int a[] = {1,1, 2, 2, 3, 3, 4, 5, 5, 6, 6, 7, 8, 8, 9, 9};
        findNum(a);
    }
}
