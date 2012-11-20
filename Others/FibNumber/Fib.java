public class Fib{
    public static void findFib(int n1, int n2){
        int currNum = n1;
        int nextNum = n1;
        int result = 0;
        System.out.println(currNum);
        System.out.println(nextNum);
        while((currNum + nextNum) <= n2){
            result = currNum + nextNum;
            System.out.println(result);
            currNum = nextNum;
            nextNum = result;

        }
    }
    public static void main(String args[]){
        findFib(10, 890);

    }
}
