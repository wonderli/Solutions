import java.util.*;
class MovingAverage {
    List<Double> nums;
    int size;
    public MovingAverage(int size) {
        this.size = size;
        this.nums = new ArrayList<Double>(this.size);
    }
    
    public double next(int val) {
        nums.add((double)val);
        if(nums.size() > size){
            nums.remove(0);
        }
        return calculate();
    }
    
    public double calculate(){
        double sum = 0;
        for(int i = 0; i < nums.size(); i++){
            sum += nums.get(i);
        }
		System.out.println(sum);
        return sum/nums.size();
        
    }
}
