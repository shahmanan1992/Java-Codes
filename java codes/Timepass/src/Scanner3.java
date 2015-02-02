import java.io.FileReader;
import java.io.IOException;
import java.util.regex.MatchResult;
import java.util.Scanner;

public class Scanner3 {
    public static void main( String[] args )throws IOException
    {
        Scanner sc  = new Scanner(new FileReader("scan.txt"));
       sc.useDelimiter("\\{|\\}|,|:");
      
     //  MatchResult result=sc.match();
	//System.out.printf("> ");
       while ( sc.hasNext() )	{
		String line = sc.next();
		System.out.println(line);
	//	System.out.printf("%s%n", line );
		//System.out.printf("> ");
	}
	sc.close();
    }
}

