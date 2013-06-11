import java.net.*;
import java.io.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
public class Main{
    LinkedList<String> queue;
    LinkedList<String> writeQueue;
    ReentrantLock lock;
    public Main(){
        queue = new LinkedList<String>();
        lock = new ReentrantLock();
    }
    public static void main(String args[]){
        Main m = new Main();
        Producer p = new Producer(m.queue);
        OneMinuteAlarm o = new OneMinuteAlarm(m.lock, m.queue, m.writeQueue);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(o);
        t1.start();
        t2.start();
    }
}
