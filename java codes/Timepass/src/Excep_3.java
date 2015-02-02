public class Excep_3 {

  private void thisMethodThrowsAnException() throws Exception {
	System.out.println("thisMethodThrowsAnException() ---> " );
	throw new Exception("in thisMethodThrowsAnException");

	// javac Excep_3.java 
	// Excep_3.java:6: unreachable statement
        // System.out.println("thisMethodThrowsAnException() <--- " );
        //  ^
	// 1 error
	// System.out.println("thisMethodThrowsAnException() <--- " );
  }

  private void caller()	{
	try {
		new Excep_3().thisMethodThrowsAnException();
		return;
	} catch (Exception e)	{
		e.printStackTrace();
		return;
	} finally	{
		System.out.println("Finally");
		System.out.println("Ok, a few things to clean up" );
	}
  }

  public static void main(String[] args) {
	new Excep_3().caller();
  }
}