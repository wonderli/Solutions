class Q6{
    public static int swapOddEven(int i){
        int maskEven = 0xaaaaaaaa;
        int maskOdd = 0x55555555;
        return ((i & maskEven) >> 1)|((i & maskOdd) << 1);
    }
    public static void main(String[] args){
        int i = 9;
        System.out.println(Q6.swapOddEven(i));
    }
}
