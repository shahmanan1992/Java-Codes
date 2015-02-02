import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Crosswordpuzzle 
{
//	static String positions_data[]={"0006D4","0105A3","0105D4","0107D4","0204A5","0208D4","0204D4"};
//	static String positions_data[]={"0006D4",/*"0105A3",*/"0105D4","0107D4","0204A5","0204D4","0303A7","0208D4","0303D7","0309D7","0402A4","0407A4","0402D5","0410D5","0501A4","0508A4","0501D3","0511D3","0600A4","0609A4","0701A4","0708A4","0802A4","0807A4","0903A7","0708D4","0704D4","0805D4","0807D4","1004A5","1105A3","0906D4"};
	static String positions_data[]={"0006D4",/*"0105A3",*/"0105D4","0107D4","0204A5","0208D4","0204D4","0303A7","0309D7","0303D7","0402A4","0407A4","0402D5","0410D5","0501A4","0508A4","0501D3","0511D3","0600A4","0609A4","0701A4","0708A4","0802A4","0807A4","0903A7","0708D4","0704D4","0805D4","0807D4","1004A5","1105A3","0906D4"};
	
	static char puzzle[][]=new char[13][13];
	static int letter_count[][]=new int[13][13];
	static int numBacktracks=0;
	static ArrayList<String> words3 = new ArrayList<String>();
	static ArrayList<String> words4 = new ArrayList<String>();
	static ArrayList<String> words5 = new ArrayList<String>();
	static ArrayList<String> words7 = new ArrayList<String>();

	public static void main(String args[])
	{

		try 
		{


			puzzle[0][6]='0';
			puzzle[1][5]='f';
			puzzle[1][6]='u';
			puzzle[1][7]='n';
			letter_count[1][5]=1;
			letter_count[1][6]=1;
			letter_count[1][7]=1;
			
			for(int i=4;i<9;i++)
			{
				puzzle[2][i]='0';
			}

			for(int i=3;i<10;i++)
			{
				puzzle[3][i]='0';
			}

			for(int i=2;i<6;i++)
			{
				puzzle[4][i]='0';
			}

			for(int i=7;i<11;i++)
			{
				puzzle[4][i]='0';
			}


			for(int i=1;i<5;i++)
			{
				puzzle[5][i]='0';
			}

			for(int i=8;i<12;i++)
			{
				puzzle[5][i]='0';
			}

			for(int i=0;i<4;i++)
			{
				puzzle[6][i]='0';
			}

			for(int i=9;i<13;i++)
			{
				puzzle[6][i]='0';
			}

			for(int i=1;i<5;i++)
			{
				puzzle[7][i]='0';
			}

			for(int i=8;i<12;i++)
			{
				puzzle[7][i]='0';
			}

			for(int i=2;i<6;i++)
			{
				puzzle[8][i]='0';
			}

			for(int i=7;i<11;i++)
			{
				puzzle[8][i]='0';
			}

			for(int i=3;i<10;i++)
			{
				puzzle[9][i]='0';
			}

			for(int i=4;i<9;i++)
			{
				puzzle[10][i]='0';
			}

			for(int i=5;i<8;i++)
			{
				puzzle[11][i]='0';
			}	
			puzzle[12][6]='0';

			//placing -1 in empty values in array
			for(int i=0;i<13;i++)
			{
				for(int j=0;j<13;j++)
				{
					if(puzzle[i][j]=='\u0000')
						puzzle[i][j]='1';
				}

			}


			//,"33A7","39D7","42A4","47A4",""}


			Scanner sc  = new Scanner( new File("words.txt"));
			while(sc.hasNext())
			{
				String line = sc.nextLine();
				if(line.length()==3)
					words3.add(line);
				if(line.length()==4)
					words4.add(line);
				if(line.length()==5)
					words5.add(line);
				if(line.length()==7)
					words7.add(line);
			}
			sc.close();

			System.out.println("Initial size of al: " + words3.size());
			System.out.println("Initial size of al: " + words4.size());
			System.out.println("Initial size of al: " + words5.size());
			System.out.println("Initial size of al: " + words7.size());

			if(puzzleSolver(0)==true)
			{
				printSolution();
				System.out.println("Backtracks: " + numBacktracks);
			}
			else
			{
				System.out.println("Backtracks: " + numBacktracks);
				System.out.println("NO SOLUTION");
			}
			
		}

		catch ( Exception e )
		{
			System.err.println("Something went wrong!");
		}
	}

	public static void printSolution()
	{
		for(int i=0;i<13;i++)
		{
			for(int j=0;j<13;j++)
			{
				System.out.print(puzzle[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static boolean puzzleSolver(int index)
	{
		if(index==positions_data.length)
		{
			printSolution();
			return true;
		}

		int length=Character.getNumericValue(positions_data[index].charAt(5));

		if(length==3)
		{

			for (int i = 0; i < words3.size(); i++) {

				String temp = words3.get(i);
				if ( wordFits(temp, positions_data[index]) ) {
					insertWord(temp, positions_data[index]);

					if ( puzzleSolver(index + 1) ) {
						return true;
					}
					
					deleteWord(temp, positions_data[index]);
				}
			}
		}
		
		if(length==4)
		{

			for (int i = 0; i < words4.size(); i++) {

				String temp = words4.get(i);
				if ( wordFits(temp, positions_data[index]) ) {
					insertWord(temp, positions_data[index]);

					if ( puzzleSolver(index + 1) ) {
						return true;
					}
					
					deleteWord(temp, positions_data[index]);
				}
			}
		}
		
		if(length==5)
		{

			for (int i = 0; i < words5.size(); i++) {

				String temp = words5.get(i);
				if ( wordFits(temp, positions_data[index]) ) {
					insertWord(temp, positions_data[index]);

					if ( puzzleSolver(index + 1) ) {
						return true;
					}
					
					deleteWord(temp, positions_data[index]);
				}
			}
		}
		
		if(length==7)
		{

			for (int i = 0; i < words7.size(); i++) {

				String temp = words7.get(i);
				if ( wordFits(temp, positions_data[index]) ) {
					insertWord(temp, positions_data[index]);

					if ( puzzleSolver(index + 1) ) {
						return true;
					}
					
					deleteWord(temp, positions_data[index]);
				}
			}
		}
		
		System.out.println("Slot "+index+" has backtracked");
		numBacktracks++;
		return false;
	}

	public static boolean wordFits(String temp, String pos_data)
	{
		int startx=Integer.parseInt(pos_data.charAt(0)+""+pos_data.charAt(1));
		int starty=Integer.parseInt(pos_data.charAt(2)+""+pos_data.charAt(3));
		int length=Character.getNumericValue(pos_data.charAt(5));

		for ( int i = 0; i < length; i++ ) {

			if ( puzzle[startx][starty] != '0' && puzzle[startx][starty] != temp.charAt(i) ) {
				return false;    
			}

			if(pos_data.charAt(4)=='A')
			{
				starty++; 
			}
			if(pos_data.charAt(4)=='D')
			{
				startx++;
			}
		}

		return true;
	}

	public static void insertWord(String temp, String pos_data)
	{
		int startx=Integer.parseInt(pos_data.charAt(0)+""+pos_data.charAt(1));
		int starty=Integer.parseInt(pos_data.charAt(2)+""+pos_data.charAt(3));
		int length=Character.getNumericValue(pos_data.charAt(5));

		for ( int i = 0; i < length; i++ )
		{
			puzzle[startx][starty] =  temp.charAt(i);
			letter_count[startx][starty]++;
			
			
			if(pos_data.charAt(4)=='A')
			{
				starty++; 
			}
			if(pos_data.charAt(4)=='D')
			{
				startx++;
			}
		}
		
		if(temp.length()==3)
		{
			words3.remove(temp);
		}
		
		if(temp.length()==4)
		{
			words4.remove(temp);
		}
		
		if(temp.length()==5)
		{
			words5.remove(temp);
		}
		
		if(temp.length()==7)
		{
			words7.remove(temp);
		}

	}

	public static void deleteWord(String temp, String pos_data)
	{
		int startx=Integer.parseInt(pos_data.charAt(0)+""+pos_data.charAt(1));
		int starty=Integer.parseInt(pos_data.charAt(2)+""+pos_data.charAt(3));
		int length=Character.getNumericValue(pos_data.charAt(5));

		for ( int i = 0; i < length; i++ )
		{
			letter_count[startx][starty]--;
			
			if ( letter_count[startx][starty] == 0 ) {                                      
                puzzle[startx][starty] = '0';
            }
			
			if(pos_data.charAt(4)=='A')
			{
				starty++; 
			}
			if(pos_data.charAt(4)=='D')
			{
				startx++;
			}
		}
		
		if(temp.length()==3)
		{
			words3.add(temp);
		}
		
		if(temp.length()==4)
		{
			words4.add(temp);
		}
		
		if(temp.length()==5)
		{
			words5.add(temp);
		}
		
		if(temp.length()==7)
		{
			words7.add(temp);
		}
		
		
	}
}