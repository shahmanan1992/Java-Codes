import java.util.Scanner;
import java.io.File;

public class W1 {
	public static void main( String[] args ) {
		try {
			int count=0, line_count=0, count_comma=0, count_Q=0,  count_ex=0, count_dot=0, count_c=0, count_sc=0, count_strt=0, count_end=0, count_ap=0, count_h=0,count_sp=0;
			int count_letter[]=new int[26];
			int count_Cletter[]=new int[26];
			int i,j,k,l;
			
			Scanner sc  = new Scanner( new File("macbeth.txt"));
			while ( sc.hasNext() )	{
				String line = sc.nextLine();
				//	System.out.println(line);// your code goes here
				String s[]=line.split(" ");
				//	System.out.println(s.length);
				for(i=0;i<s.length;i++)
				{
					count++;
				}
	
				for(j=0;j<line.length();j++)
				{
					char ch=line.charAt(j);
					int letter= (int)ch;
					if(letter>=97 && letter<=122)
					{
						count_letter[letter-97]++;
					}
				}
				
				for(k=0;k<line.length();k++)
				{
					char ch=line.charAt(k);
					int cletter= (int)ch;
					if(cletter>=65 && cletter<=90)
					{
						count_Cletter[cletter-65]++;
					}
				}
				
				for(l=0;l<line.length();l++)
				{
					if(line.charAt(1)==' ')
						count_sp++;
					if(line.charAt(l)=='?')
						count_Q++;
					if(line.charAt(l)=='!')
						count_ex++;
					if(line.charAt(l)==',')
						count_comma++;
					if(line.charAt(l)=='.')
						count_dot++;
					if(line.charAt(1)==(char)39)
						count_ap++;
					if(line.charAt(l)==':')
						count_c++;
					if(line.charAt(l)==';')
						count_sc++;
					if(line.charAt(l)=='[')
						count_strt++;
					if(line.charAt(l)==']')
						count_end++;
					if(line.charAt(l)=='-')
						count_h++;
					
				}
				line_count++;
			}
			
			System.out.println( "No of lines="+line_count);
			System.out.println("No of words="+ count);
			
			for(k=0;k<count_letter.length;k++)
			{
				System.out.println("NO. OF  " + "'"+ (char)(97+k) + "'" + "=" +count_letter[k]) ;
			}
			
			for(k=0;k<count_Cletter.length;k++)
			{
				System.out.println("NO. OF  " + "'"+ (char)(65+k) + "'" + "=" +count_Cletter[k]) ;
			}
			System.out.println("No of ' '="+ count_sp);
			System.out.println("No of '?'="+ count_Q);
			System.out.println("No of '!'="+ count_ex);
			System.out.println("No of ','="+ count_comma);
			System.out.println("No of '.'="+ count_dot);
			System.out.println("No of '''="+ count_ap);
			System.out.println("No of ':'="+ count_c);
			System.out.println("No of ';'="+ count_sc);
			System.out.println("No of '['="+ count_strt);
			System.out.println("No of ']'="+ count_end);
			System.out.println("No of '-'="+ count_h);
			sc.close();
			
		}
		catch ( Exception e )	
		{
			System.err.println("Something went wrong!");
		}
	}
}
