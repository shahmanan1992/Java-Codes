public class S3 {



  private void m4(Exception e)	{
	e.printStackTrace();
  }
  private void m3()throws Exception	{
	try { 
		System.out.println("a");
		int x = 1/0;
		System.out.println("b");
	} catch (Exception e)	{
	
		System.out.println("c");
		throw new Exception();
		//return;
	} finally	{
		System.out.println("dxxx");
	}
  }
  private void m2()throws Exception	{
	try {
		try { 
			m3();
			System.out.println("bbb");
		} catch (Exception e)	{
			//e.printStackTrace();
			System.out.println("c");
			int x = 1/0;
			System.out.println("d");
		}
	} catch (Exception e)	{
		System.out.println("e");
		throw new Exception();
	} finally	{
		System.out.println("f");
	}
  }
  private void m1()	{
	try {
		m2();
	} catch (Exception e)	{
		System.out.println("1");
		System.exit(0);
	} finally	{
		System.out.println("g");
	}
  }
  public static void main(String[] args) {
	new S3().m1();
  }
}