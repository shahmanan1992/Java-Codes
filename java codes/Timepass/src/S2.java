public class S2 extends S11 {

   public static int staticV = 2;
   public int instanceV = 4;		

  public static void printsStatic()	{
	System.out.println("S2: staticV: " + staticV );
  }
  public void printInstance()	{
	System.out.println("S2: instanceV: " + instanceV );
  }

  public static void main(String args[]) {
		printsStatic();
		new S2().printInstance();
  }
}
