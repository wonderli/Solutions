import java.nio.*;
import java.util.*;
class AdaptedRandomChar16 extends RandomChars implements Readable{
    private int count;
    public AdaptedRandomChar16(int count){
        this.count = count;
    }
    public int read(CharBuffer cb){
        if(count-- == 0)
            return -1;
        String result = Character.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(new AdaptedRandomChar16(10));
        while(s.hasNext()) 
            System.out.print(s.next() + " ");
    }
}
