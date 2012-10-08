public class Q55{
    public static int countBruteForce(int num){
        int count = 0;
        while(num != 0){
            if((num & 1) == 1) count++;
            num = num >> 1;
        }
        return count;
    }
    public static int count(int num){
        int count = 0;
        while(num != 0) {
            num = num & (num - 1);
            count++;
        }
    }
    public static void main(String args[]){
        int num = 11;
        System.out.println(countBruteForce(num));

    }
}
