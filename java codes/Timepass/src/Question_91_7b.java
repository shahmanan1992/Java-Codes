public class Question_91_7b {

  private void method3(int index) throws Exception, NullPointerException {
		if ( index == 3 )	{
			throw new Exception("something went wrong");
		} else {
			throw new NullPointerException("something went wrong");
		}
  }
  private void method2(int index) throws Exception, NullPointerException {
		try {
			throw new NullPointerException("something went wrong");
		} catch (Exception e)	{
			System.err.println("1");
			return;
		} finally	{
			System.err.println("2");
		}
  }
  private void method1(int index)	 {
		try {
			if ( index == 2 )
				System.err.println("3");
			if ( index == 1 )
				method2(index);
			else
			{
				System.out.println("coming here");
				method3(index);
			}
				
			System.err.println("4");
		} 
		catch (NullPointerException e)	{
			System.err.println("5");
		} 
		catch (Exception e)	{
			System.err.println("6");
		} 
		finally	{
			System.err.println("7");
		}
  }

  public static void main(String[] args) {
	new Question_91_7b().method1(1);
		System.err.println("..........");
	new Question_91_7b().method1(2);
		System.err.println("++++++++++");
	new Question_91_7b().method1(3);
		System.err.println("==========");
	new Question_91_7b().method1(4);
  }
}
/*
1
2
4
7
..........
3
5
7
++++++++++
6
7
==========
5
7
*/