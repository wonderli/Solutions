//For exercise 16
import java.nio.*;
import java.util.*;
class RandomChars {
	public static Random rand = new Random(47);
    public static final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
	public char next() {
        return alphabet[rand.nextInt(51)];
	}
	public static void main(String[] args) {
		RandomChars rc = new RandomChars();
		for(int i = 0; i < 7; i++) {
			System.out.println(rc.next() + " ");
		}
	}

}
