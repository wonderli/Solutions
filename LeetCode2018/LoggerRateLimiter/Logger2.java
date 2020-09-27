import java.util.*;

public class Logger2 {

    Map<String, Integer> map;

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
            int t = map.get(message);
            if (t > timestamp - 10) {
                should = false;

            }else {
                map.put(message, timestamp);
            }
        } else {
            map.put(message, timestamp);
        }
        return should;
    }
}

