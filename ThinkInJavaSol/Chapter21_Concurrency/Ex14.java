import java.util.concurrent.*;
import java.util.*;
public class Ex14 implements Runnable{
    private static int timers = 0;
    private static int tasks = 0;
    public void run(){
        try{
            while(timers < 2000){
                timers++;
                Timer t = new Timer();
                t.schedule(new TimerTask(){
                    public void run(){
                        tasks++;
                        if(timers %100 == 0){
                            System.out.println(timers + " timers did " + tasks + " tasks");
                        }
                    }
                }, 0);
                try{
                    TimeUnit.MILLISECONDS.sleep(30);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
                t.cancel();
            }
        }finally {
            System.out.println("Done. " + timers + " timers completed " + tasks + " tasks");
        }
    }

    public static void main(String args[]){
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Ex14());
        exec.shutdown();
    }
}

