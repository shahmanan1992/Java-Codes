
import java.util.Scanner;

public class Scanner2 {
    public static void main( String[] args ) {
        Scanner sc  = new Scanner( System.in);
	System.out.printf("> ");
        while ( sc.hasNext() )	{
		Integer aInteger = sc.nextInt();
		System.out.printf("-%d-%n", aInteger );
		System.out.printf("> ");
	}
	sc.close();
    }
}

