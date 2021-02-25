import java.util.*;
class Solution {
    public double angleClock(int hour, int minutes) {
        int oneMinAngle = 6;
        int oneHourAngle = 30;
        double minuteAngle = oneMinAngle * minutes;
        double hourAngle = (hour % 12 + minutes /60.0) * oneHourAngle;
        double diff = Math.abs(hourAngle - minuteAngle);
        return Math.min(diff, 360 - diff);
        
    }
}
