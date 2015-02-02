/* 
 * Palindrome.java 
 * 
 * Version: 
 *     1 
 * 
 * 
 */
import java.io.*;
import java.util.Scanner;
import java.io.File;

/**
 * This program takes a text file as input and checks for 
 * palindrome within the text file.Also this program searches
 * for any paindromes within any palindrome and produces the
 * desired result.
 * 
 * @author      Manan Shah     	605004112	
 * @author      Vinay Kumbhar	613009443	
 */

public class Palindrome {
	
	/**
	   * The main program.
	   *
	   * @param    args   
	   */
	public static void main( String[] args ) {
		int count=0;
		try {
			//Reads the input text file from current directory
			Scanner sc  = new Scanner( new FileReader("palindrome_1.txt"));
			//Scanner sc  = new Scanner( new FileReader("Manan Shah"));
			while ( sc.hasNext() ) {
				String line = sc.nextLine();
				
			// This command splits the string by only words and doesn't delimiters.
				String result[]=line.split("[\\W]");
				
				
				StringBuilder word = new StringBuilder();
				for (int i = 0; i < result.length; i++) {
				//	System.out.println(result[i]);
				   word.append(result[i]);
				}
				// This line converts the string builder to string
				String full_line = word.toString();
				
				full_line=full_line.toLowerCase();
				for(int i=0;i<full_line.length()-1;i++) {
					String s="";
					s=s+full_line.charAt(i);
					for(int j=i;j<full_line.length()-1;j++)	{
						s=s+full_line.charAt(j+1);
						//It checks for palindrome and also checks the condition about lngth of word.
						// It only accepts words to check for palindrome that are having length greater than 2.
						if(s.length()>2 && isPalindrome(s))	{
							System.out.println(s);
							count++;
						}
						
					}
				}
		}
			sc.close();
		} 
		catch ( Exception e ) {
			System.err.println("Something went wrong!");
		}
		System.out.println("No. of palindrome="+ count );
	}
	
	 /**
	   * Checks if the given word is palindrome or not.
	   *
	   * @param    length   length of string
	   *
	   * @return   boolean to check palindrome or not
	   */

	public static boolean isPalindrome(String s) {
		int length=s.length();

		for(int i=0; i<(length/2)+1; i++) {
			if(s.charAt(i) != s.charAt(length-1-i))	{
				return false;
			}
		}
		return true;
	}
}
