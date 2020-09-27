import java.util.*;

public class Logger {

    Map<String, PriorityQueue<Integer>> map;

    public Logger() {
        this.map = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean should = true;
        if (map.containsKey(message)) {
            PriorityQueue<Integer> pq = map.get(message);
            int t = pq.peek();
            if (t > timestamp - 10) {
                should = false;

            }else {
                pq.add(timestamp);
            }
        } else {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            pq.add(timestamp);
            map.put(message, pq);
        }
        return should;
    }
}

