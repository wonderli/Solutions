import java.util.*;
class Solution {
    double radius;
    double xc;
    double yc;
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.xc = x_center;
        this.yc = y_center;
    }
    
    public double[] randPoint() {
        double x0 = xc - radius;
        double y0 = yc - radius;
        while(true){
            double x1 = x0 + Math.random() * radius * 2;
            double y1 = y0 + Math.random() * radius * 2;
            if((x1 - xc) * (x1 - xc) + (y1 - yc) * (y1 - yc) <= radius * radius){
                return new double[]{x1, y1};
            }
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
