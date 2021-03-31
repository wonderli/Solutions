public class Ex1RunnerC implements Runnable{
    public Ex1RunnerC(){
        System.out.println("Constructing Ex1RunnerC");
    }
    public void run(){
        for(int i = 0; i < 3; i++){
            System.out.println("Hello from Ex1RunnerC");
            Thread.yield();
        }
        System.out.println("Ex1RunnerC Complete");
        return;
    }
}
