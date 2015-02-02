import java.util.Scanner;
import java.io.File;

public class S5 {
	// this method has to return all palindromes of line
	// you need to add the return type and the body of the method.
	// assume there are less than 100 palindroms in it ...
    public static String[] isApalinDrome(String line)	{
	String [] soFar = new String[100];
	int counter = 0;
        for ( int start = 0; start < line.length(); start ++ )  {
                for ( int end = start + 3; end <= line.length(); end ++ )       {
                        String tryThisOne = line.substring(start, end );
                        if ( isThisAPalindrome(tryThisOne) )    {
                        	System.out.println(tryThisOne);
                                soFar[counter++] = tryThisOne;
                        }
                }
        }
	String [] result = new String[counter];
        for ( int index = 0; index < counter; index ++ ) 
		result[index] = soFar[index];
		
        return result;
    }

    public static boolean isThisAPalindrome(String line )       {
        int index = 0;
        while ( (index < line.length() )  &&
                ( line.charAt(index) == line.charAt(line.length() - index - 1) )
              )
        	          index ++;
	return index == line.length() ;
    }
    public static void main( String[] args ) {
		String line = "annana";
		String [] palindromes = isApalinDrome(line);
		if ( palindromes.length > 0 )
			System.out.println("Found so many palindromes: " + palindromes.length);
    }
}
