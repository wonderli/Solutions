import java.util.*;
class MyCalendar {
    private class Event{
        int start;
        int end;
        public Event(int s, int e){
            this.start = s;
            this.end = e;
        }
    }
    List<Event> list;
    public MyCalendar() {
        list = new LinkedList<>();
    }
    
    public boolean book(int start, int end) {
        Event event = new Event(start, end);
        for(Event e : list){
            if(intersect(event, e)){
                return false;
            }
        }
        list.add(event);
        Collections.sort(list, (a, b) -> (a.start == b.start ? a.end - b.end : a.start - b.start));
        return true;
    }
    
    private boolean intersect(Event a, Event b){
        if(b.end <= a.start) return false;
        if(b.start >= a.end) return false;
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */