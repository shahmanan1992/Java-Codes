class FlowC
{
   int[] numbers = { 3, 5, 6, 1, 0, -1, 22, 14, 5, 9, 0, 1, -1 };

   static boolean trueIfZero(double n) {
	return n == 0.0;
   }
   static boolean greaterZero(double n) {
	return n > 0.0;
   }
   static double aDividedByN(double a, double b)      {
	return a / b;
   }

   static int test_1(int n)	{
	if ( ++n == 1 )
		return 1;
	else if ( n-- == 1 )
		return 2;
	else if ( --n == 0 )
		return 3;
	else
		return 4;
   }
   static int test_2(int n)	{
        n = -1;
	while ( n < 4 )	{
		if ( n-- == -1 )
			n = 1;
		if ( ( n + 1 ) % 2 == 0 )
			n = 2;
		else if ( n == 3 )
			n = n++;
		n = n + n;
	}
	if ( ( n = 1 ) == 1 )
		n = 3;
	return n;
   }
   static int test_3(int a, int b)	{
	if ( a < b )
		return a;
	else
		return b;
   }
   static double test_4(double a, double b)	{
	if  (trueIfZero(a) )
		return aDividedByN(b , a );
	if  (greaterZero(a) | trueIfZero(a) )
		return aDividedByN(b , a );
	if  (greaterZero(a) || trueIfZero(a) )
		return aDividedByN(b , a );
	if  (greaterZero(a) & trueIfZero(a) )
		return aDividedByN(b , a );
	if  (greaterZero(a) && trueIfZero(a) )
		return aDividedByN(b , a );
	if  (! greaterZero(a) && ! trueIfZero(a) )
		return aDividedByN(b , a );
	if  ( greaterZero((int)a >>1 ) && trueIfZero(a) )
		return aDividedByN(b , a );
	if  ( greaterZero((int)a >>>1 ) && trueIfZero(a) )
		return aDividedByN(b , a );
	
	return 0.0;
   }


   public static void main(String args[])
   {  
/*
	// a) create 4 statements so such test_1 returns all possible values
	// is it possible to get all 4 possible values?
	// System.out.println("a:	test_1(0):	" + test_1(i) );

	// b) explain the execution of test_2
	System.out.println("b:	test_2(2):	" + test_2(2) );

	// c) simplyfiy test_3 by using a ?: statement
	System.out.println("c:	test_2(2):	" + test_2(2) );
	
	// d) find the minumum of all numbers in number by using one for loop

	// e) test_4 wil not compile, why? Fix it?
	// create a/b pairs, so such all return statements are executed
	// is it possible to execute all  return statements.
	System.out.println("e:	test_3(2, 2):	" + test_3(2, 2) );
*/
	  //a) 
	   int n=test_1(0);
	   System.out.println(n);
	   n=test_1(1);
	   System.out.println(n);
	   n=test_1(2);
	   System.out.println(n);
	
	   
	   //b)
	  // It returns 3.
	   
	   //c)
	  // make changes inside function as : return a < b ? a : b
	   
	   //d)
   }
}