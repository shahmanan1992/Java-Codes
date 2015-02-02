/* 
 * Exceptions.java 
 * 
 * Version: 
 *     1
 */
import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

/**
 * This program produces different types of checked and unchecked exceptions.
 *
 * @author      Manan Shah     605004112	
 * @author      Vinay Kumbhar  613009443
 */
class Exceptions
{

	/**
	 * The main program.
	 *
	 * @param    args    
	 */
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		/*System.out.println("Enter the value");
			int n=Integer.parseInt(br.readLine());*/

		//Running for loop to get different types of exceptions
		for(int n=1;n<=11;n++)
		{
			try
			{
				switch(n)
				{
				//This case performs Arithmetic exception
				case 1:
					int a=1,b=0;
					int c=a/b;
					break;

					//This case performs Array IndexOutOfBounds Exception
				case 2:
					int array[]= new int[5];
					System.out.println(array[6]);
					break;

					//This case performs Array Store Exception
				case 3:
					Object array2[]=new String[3];
					array2[1]=new Integer(2);
					break;

					//This case performs Class Cast exception	
				case 4:
					Object ob= new Integer(2);
					System.out.println((String)ob);
					break;

					//This case performs Illegal Argument Exception	
				case 5:
					Integer m = new Integer(null);
					break;

					//This case performs Null Pointer Exception
				case 6:
					Integer no = new Integer(10);
					no=null;
					System.out.println(no.intValue());

					//This case performs Negative Array Size Exception
				case 7:
					int v[]=new int[-5];
					//This case performs Illegal State Exception
				case 8:List s=new LinkedList();
				s.add("Ram");
				s.add("Ganesh");
				s.add("Paul");
				s.add("praveen");
				Iterator i=s.iterator();
				i.remove(); // the next() method is not used before the remove() method   
				System.out.println(s);

				//This case performs Class Not Found Exception						
				case 9: Class cls;
				cls = Class.forName("MainClass");
				Method main[] = cls.getDeclaredMethods();
				System.out.println(main[0].toString());

				//This case performs String Index Out Of Bounds Exception	    					
				case 10: String str=new String("HELLO");
				char single=str.charAt(5);
                
				//This case performs No Such Method Exception
				case 11:  Class nsm = Class.forName("java.lang.String");
				Class[] paramTypes = new Class[5];
				Method mnsm = nsm.getDeclaredMethod("fooMethod", paramTypes);

				}
			}

			catch(ArithmeticException e){
				System.out.println("Exception occured: "+e);
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Exception occured: "+e);
			}
			catch(ArrayStoreException e)
			{
				System.out.println("Exception occured: "+e);
			}
			catch(ClassCastException e)
			{
				System.out.println("Exception occured: "+e);
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Exception occured: "+"IllegalArgument Exception");
			}
			catch(NullPointerException e)
			{
				System.out.println("Exception occured: "+e);
			}
			catch(NegativeArraySizeException e)
			{
				System.out.println("Exception occured: "+e);
			}
			catch(IllegalStateException e)
			{
				System.out.println("Exception occured: "+e);
			}
			catch(ClassNotFoundException e)
			{
				System.out.println("Exception occured: "+e);
			}
			catch(StringIndexOutOfBoundsException e)
			{
				System.out.println("Exception occured: "+e);
			}
			catch(NoSuchMethodException e)
			{
				System.out.println("Exception occured: "+e);
			}



		}
	}
}