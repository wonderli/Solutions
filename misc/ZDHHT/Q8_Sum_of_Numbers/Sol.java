public class Sol{
    public static int N = 0;
    public static int Sum = 0;
    public Sol(){
        N++;
        Sum += N;
    }
    public static void main(String args[]){
        int n = 100;
        Sol sol[] = new Sol[100];
        for(int i = 0; i < n; i++){
            sol[i] = new Sol();
        }
        int sum = Sol.Sum;
        System.out.println(sum);
    }
}
