public class Ex1RunnerA implements Runnable{
    public Ex1RunnerA(){
        System.out.println("Constructing Ex1RunnerA");
    }
    public void run(){
        for(int i = 0; i < 3; i++){
            System.out.println("Hello from Ex1RunnerA");
            Thread.yield();
        }
        System.out.println("Ex1RunnerA Complete");
        return;
    }
}
