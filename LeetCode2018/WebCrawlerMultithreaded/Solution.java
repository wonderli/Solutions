/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * 
 * */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

interface HtmlParser {
     public List<String> getUrls(String url);
 }


class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        int threadPoolSize = 10;
        
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize, r->{
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });

        Deque<Future<List<String>>> tasks = new ArrayDeque<>();
        Set<String> visited = ConcurrentHashMap.newKeySet();
        visited.add(startUrl);
        
        String hostName = startUrl.split("/")[2];

        Future<List<String>> future = executorService.submit(getCallableTask(startUrl, visited, htmlParser, hostName));

        tasks.addLast(future);
        
        try{
            while(!tasks.isEmpty()){
                List<String> newUrls = tasks.removeFirst().get();
                for(String url : newUrls){
                    if(!visited.contains(url)){
                        Future<List<String>> newFuture = executorService.submit(getCallableTask(url, visited, htmlParser, hostName));
                        tasks.add(newFuture);
                        visited.add(url);
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        executorService.shutdown();
        
        
        return new LinkedList<String>(visited);
    }
    
    private Callable<List<String>> getCallableTask(String url, Set<String> visited, HtmlParser htmlParser, String hostName){
        return new Callable<List<String>>(){
            
          @Override
            public List<String> call() throws Exception{
                List<String> list = new ArrayList<>();
                for(String url : htmlParser.getUrls(url)){
                    if(!visited.contains(url) && url.contains(hostName)){
                        list.add(url);
                    }
                }
                return list;
            }
            
        };
    }
}
