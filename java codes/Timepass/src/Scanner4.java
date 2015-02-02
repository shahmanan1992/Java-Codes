/* 
 * example is from: http://www.cs.rit.edu/~hpb/Jdk5/api/java/util/Scanner.html
 */
import java.util.Scanner;
import java.util.regex.MatchResult;

public class Scanner4 {
    public static void printIt(String input)	{
	Scanner s = new Scanner(input);

	s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");

	MatchResult result = s.match();
	for (int i=1; i<=result.groupCount(); i++) {
		System.out.println(i + ": " + result.group(i));
	}
    } 

    public static void main( String[] args ) {
	String input = "1 fish 2 fish red fish blue fish";
	printIt(input);

    }
}

