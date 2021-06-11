import java.util.*;
class MyCalendar {

    private TreeMap<Integer, Integer> events;
    public MyCalendar() {
        events = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prevStart = events.floorKey(start);
        Integer nextStart = events.ceilingKey(start);
        
        if((prevStart != null && start < events.get(prevStart)) || (nextStart !=null && end > nextStart)) return false;
        
        events.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */