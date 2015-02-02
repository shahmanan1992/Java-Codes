/* 
 * W1.java 
 * 
 * Version: 
 *     1.0 
 */
import java.io.File;
import java.util.Scanner;
/**
 * This program takes as a text input file containing English words and counts
 * the number of words, characters, lines and occurrences of all printable characters
 * and displays them
 * 
 * @author		Vinay Kumbhar	613009443
 * @author		Manan Shah		605004112
 */



public class Test {
	
/**
 * The main program.
 *
 * @param    args    
 * @exception Exception
 */
	public static void main( String[] args ) {
		try {
			int count=0, line_count=0,blank_count=0;
			int count_letter[]=new int[90];
			int i,j,k,count_char=0;

			Scanner sc  = new Scanner( new File("macbeth.txt"));
			
			//Take input from text file
			while ( sc.hasNext() )
			{
				String line = sc.nextLine();
				//Counting occurrences of blank lines
				if(line.isEmpty())
				{
					blank_count++;
				}

				line_count++;
				String s[]=line.split("\\s+");
				//Counting number of words
				for(i=0;i<s.length;i++)
				{
					if(s[i].isEmpty())
						continue;
					count++;
				}
				//Counting occurrences of all printable characters
				for(j=0;j<line.length();j++)
				{
					char ch=line.charAt(j);
					int letter= (int)ch;
					if(letter>=32 && letter<=122)
					{
						count_letter[letter-32]++;
						count_char++;
					}
				}

			}

			System.out.println("No of characters= "+count_char);
			System.out.println( "No of lines= "+line_count);
			System.out.println("No of words= "+ count);
			System.out.println("No of blank line= "+ blank_count);
			
			//Print out the character count
			for(k=0;k<count_letter.length;k++)
			{
				if(count_letter[k]!=0)
					System.out.println("NO. OF '"+(char)(k+32)+"'= "+count_letter[k]) ;
			}

			sc.close();

		}
		catch ( Exception e )	
		{
			System.err.println("Something went wrong!");
		}
	}
}
