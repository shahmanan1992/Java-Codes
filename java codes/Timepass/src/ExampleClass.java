public class  ExampleClass	{
 static int aLocalVariable = 3;

  public ExampleClass()	{
	aLocalVariable = 2;
  }
  public ExampleClass(int aLocalVariable)	{
	this.aLocalVariable = aLocalVariable;
	//aLocalVariable = 6;
  }

  public static void main(String args[] )	{
	ExampleClass aExampleClass = new ExampleClass();
	aExampleClass = new ExampleClass(3);
	System.out.println("the value is: " + aExampleClass.aLocalVariable);
	System.out.println(aLocalVariable);
  }
}