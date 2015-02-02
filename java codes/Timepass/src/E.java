import java.io.*;
import java.lang.reflect.Method;
import java.util.*;
class E
{
	public static void main(String args[]) throws IOException
	{
		try
		{
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the value");
			int n=Integer.parseInt(br.readLine());
			switch(n)
			{
			case 1:
				//Arithmetic Exception
				int a=1,b=0;
				int c=a/b;
				break;
			case 2:
				int array[]= new int[5];
				System.out.println(array[6]);
				break;
			case 3:
				Object array2[]=new String[3];
				array2[1]=new Integer(2);
				break;
			case 4:
				Object ob= new Integer(2);
				System.out.println((String)ob);
				break;
			case 5:
				Integer m = new Integer(null);
				break;
			case 6:
				Integer no = new Integer(10);
				no=null;
				System.out.println(no.intValue());
			case 7:
				int v[]=new int[-5];

			case 8:List s=new LinkedList();
					s.add("Ram");
					s.add("Ganesh");
					s.add("Paul");
					s.add("praveen");
					Iterator i=s.iterator();
					i.remove(); // the next() method is not used before the remove() method   
					System.out.println(s);
									
			case 9: Class cls;
					 cls = Class.forName("MainClass");
				     Method main[] = cls.getDeclaredMethods();
				     System.out.println(main[0].toString());
				    					
			case 10: String str=new String("HELLO");
					 char single=str.charAt(5);
			
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
	}
}