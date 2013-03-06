public class Ex1{
    public static void main(String args[]){
        Thread ta = new Thread(new Ex1RunnerA());
        Thread tb = new Thread(new Ex1RunnerB());
        Thread tc = new Thread(new Ex1RunnerC());
        ta.start();
        tb.start();
        tc.start();
    }
}
