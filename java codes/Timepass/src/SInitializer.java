public class SInitializer {

  static public int intS;		

  public SInitializer ()	{
	System.out.println("in S constructor");
  }

  static {
	System.out.println("S:Static 1");
  }

  static {
	System.out.println("S: Static 2");
  }

  public static void main(String args[])	{
   String s="manan";
   s=s+" shah";
   System.out.println(s);
   
}
}