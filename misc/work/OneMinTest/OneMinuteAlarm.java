import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
public class OneMinuteAlarm implements Runnable {
    ReentrantLock lock;
    LinkedList<String> queue;
    LinkedList<String> writeQueue;
    Object ready;
    boolean flag;
    public OneMinuteAlarm(LinkedList<String> queue, LinkedList<String> writeQueue, Object ready, boolean flag){
        this.lock = lock;
        this.queue = queue;
        this.writeQueue = writeQueue;
        this.ready = ready;
        this.flag = flag;
    }
    public void run(){
        while(true){
            try{
                Thread.sleep(3 * 1000);
                    ready.wait();
                    writeQueue = new LinkedList<String>();
                    for(String s : queue){
                        System.out.println(s);
                        writeQueue.add(s);
                    }
                    queue.clear();
                    ready.notifyAll();
                Thread t = new Thread(new OneMinuteFileWriter(writeQueue));
                t.start();
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}

