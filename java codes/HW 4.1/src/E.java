/*
 * E.java
 *
 * Version:
 *     1
 */
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author      Author name
 * @author      Vinay Kumbhar   613009443
 * @author      Manan Shah      605004112
 *
 * This program calculates Mathematical e in three different and finds the difference between constant e.
 * It also checks if the difference is < than delta which is ~ 0.001
 */
public class E {

	/**
	 * The main program.
	 *
	 * @param    args
	 */
	public static void main(String args[])
	{
		double delta = 0.001;
		double e1 = calculateEversion1(delta);
		NumberFormat formatter = new DecimalFormat("#.#####");  
		String f = formatter.format(e1);  
		System.out.println("Result of e1 ="+f+" is less than delta "+delta);

		double e2 = calculateEversion2(delta);
		String f1 = formatter.format(e2);  
		System.out.println("Result of e2 ="+f1+" is less than delta "+delta);

		double e3 = calculateEversion3(delta);
		String f2 = formatter.format(e3);  
		System.out.println("Result of e3 ="+f2+" is less than delta "+delta);

	}

	/**
	 * Given a delta value finds absolute difference between calculated e and constant e
	 * 
	 * @param delta Difference threshold
	 * @return double returns absolute difference between your_e and e
	 */
	public static double calculateEversion1(double delta)
	{
		double your_e=0.0;
		int i=0;
		//Do while absolute difference is >= delta
		while(Math.abs(0.5*your_e-Math.E)>=delta)
		{
			int f=factorial(i);
			your_e+=(double)(i+1)/(double)f;
			i++;
		}

		return Math.abs(0.5*your_e-Math.E);
	}

	/**
	 * Given a delta value finds absolute difference between calculated e and constant e
	 * 
	 * @param delta Difference threshold
	 * @return double returns absolute difference between your_e and e
	 */
	public static double calculateEversion2(double delta)
	{
		double your_e=0.0;
		int i=0;
		//Do while absolute difference is >= delta
		while(Math.abs(1/your_e-Math.E)>=delta)
		{
			your_e+=(double)(1-(2*i))/(double)(factorial(2*i));
			i++;
		}
		return Math.abs(1/your_e-Math.E);
	}

	/**
	 * Given a delta value finds absolute difference between calculated e and constant e
	 * 
	 * @param delta Difference threshold
	 * @return double returns absolute difference between your_e and e
	 */
	public static double calculateEversion3(double delta)
	{
		double your_e=0.0;
		int i=0;
		//Do while absolute difference is >= delta
		while(Math.abs(your_e-Math.E)>=delta)
		{
			your_e+=1/(double)factorial(i);
			i++;
		}
		return Math.abs(your_e-Math.E);
	}

	/**
	 * Given a number calculates factorial
	 * 
	 * @param f       number
	 * @return int    returns factorial
	 */
	public static int factorial(int f)
	{
		if(f==0|| f==1)
			return 1;
		else
			return (f * factorial(f-1));
	}

}

