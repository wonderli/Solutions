public class Ex1RunnerB implements Runnable{
    public Ex1RunnerB(){
        System.out.println("Constructing Ex1RunnerB");
    }
    public void run(){
        for(int i = 0; i < 3; i++){
            System.out.println("Hello From Ex1RunnerB");
            Thread.yield();
        }
        System.out.println("Ex1RunnerB Complete");
        return;
    }
}
