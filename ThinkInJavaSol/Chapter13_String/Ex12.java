import java.util.regex.*;
import java.util.*;
public class Ex12 {
    static public final String POEM =
        "Twas brillig, and the slithy toves\n" +
        "Did gyre and gimble in the wabe.\n" +
        "All mimsy were the borogoves,\n" +
        "And the mome raths outgrabe.\n\n" +
        "Beware the Jabberwock, my son,\n" +
        "The jaws that bite, the claws that catch.\n" +
        "Beware the Jubjub bird, and shun\n" +
        "The frumious Bandersnatch.";
    public static void main(String[] args) {
        Matcher m =
            Pattern.compile("(^[a-z]|\\s+[a-z])\\w+")
            .matcher(POEM);
        //System.out.println(Pattern.compile("(^[a-z]|\\s+[a-z])\\w+").pattern());
        Set<String> set = new TreeSet<String>();
        while(m.find()) {
            set.add(m.group());
        }
        System.out.println("Unique words " + set.size());
        System.out.println(set);
    } 
}
