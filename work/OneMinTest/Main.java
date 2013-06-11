import java.net.*;
import java.io.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
public class Main{
    LinkedList<String> queue;
    LinkedList<String> writeQueue;
    ReentrantLock lock;
    Object ready;
    public Main(){
        this.queue = new LinkedList<String>();
        this.writeQueue = new LinkedList<String>();
        this.lock = new ReentrantLock();
        this.ready = new Object();
    }
    public static void main(String args[]){
        Main m = new Main();
        Producer p = new Producer(m.queue, m.ready, m.flag);
        OneMinuteAlarm o = new OneMinuteAlarm(m.queue, m.writeQueue, m.ready, m.flag);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(o);
        t1.start();
        t2.start();
    }
}
