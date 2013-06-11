import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
public class OneMinuteAlarm implements Runnable {
    ReentrantLock lock;
    LinkedList<String> queue;
    LinkedList<String> writeQueue;
    public OneMinuteAlarm(ReentrantLock lock, LinkedList<String> queue, LinkedList<String> writeQueue){
        this.lock = lock;
        this.queue = queue;
        this.writeQueue = writeQueue;
    }
    public void run(){
        while(true){
            try{
            Thread.sleep(3 * 1000);
            lock.lock();
            writeQueue = (LinkedList<String>)queue.clone();
            queue = new LinkedList<String>();
            lock.unlock();
            Thread t = new Thread(new OneMinuteFileWriter(writeQueue));
            t.start();
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}

