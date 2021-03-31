import java.util.regex.*;
public class Ex10{
    public static void main(String args[]) {
        String s = new String("Java now has regular expressions");
        String[] r = new String[9];
        r[0] = new String("^Java");
        r[1] = new String("\\Breg.*");
        r[2] = new String("n.w\\s+h(a|i)s");
        r[3] = new String("s?");
        r[4] = new String("s*");
        r[5] = new String("s+");
        r[6] = new String("s{4}");
        r[7] = new String("S{1}");
        r[8] = new String("s{0,3}");
        for(String arg : r) {
            System.out.println("Regular expression: \"" + arg + "\"" );
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(s);
            if(!m.find())
                System.out.println("No match found for " + "\"" + arg + "\"");
            m.reset();
            while(m.find()){
                System.out.println("Match \"" + m.group() + "\"" + " at positions " + m.start() + ((m.end() - m.start() < 2) ? "" : ("-" + (m.end() - 1))));
            }
        }
    }
}
