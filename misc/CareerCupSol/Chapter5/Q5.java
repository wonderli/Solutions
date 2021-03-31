class Q5{
    public static int findFlipNumber(int a, int b){
        int c = a^b;
        int count = 0;
        do{
           if((c & 1)== 1){
               count++;
           }
           c = c >> 1;
        }while(c != 0);
        return count;
    }
    public static void main(String[] args){
        int a = 9;
        int b = 12;
        System.out.println(Q5.findFlipNumber(a, b));
    }
}
