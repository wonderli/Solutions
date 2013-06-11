import java.net.*;
import java.io.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
public class Producer implements Runnable{
    LinkedList<String> queue;
    public Producer(LinkedList<String> queue){
        this.queue = queue;
    }
    public void run(){
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(12345);
        }catch(IOException e){
            System.err.println("Could not listen on port: 12345");
            System.exit(1);
        }
        Socket clientSocket = null;
        try{
            clientSocket = serverSocket.accept();
        }catch(IOException e){
            System.err.println("Accept failed");
            System.exit(1);
        }
        try{
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while((inputLine = in.readLine())!=null){
                System.out.println(inputLine);
                queue.add(inputLine);
            }
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}

