import java.util.regex.*;
public class Ex11{
    public static void main(String args[]) {
        String r = new String("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");
        System.out.println("Regular Expr: " + r);
        String s = new String("Arline ate eight apples and one orange while Anita hadn’t any");
        System.out.println("Statement Expr: " + s);
        Pattern p = Pattern.compile(r);
        System.out.println(p.pattern());
        Matcher m = p.matcher(s);
        if(!m.find())
            System.out.println("Regular Expression doesn't find");
        while(m.find()) {
            System.out.println("Match \"" + m.group() + "\"" + " at " + m.start() + " end " + (m.end() - 1));
        }
    }
}
