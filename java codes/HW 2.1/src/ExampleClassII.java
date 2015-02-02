public class  ExampleClassII	{
  static int aInstanceVariable = 42;
  static int[] intArray = new int[4];

  public ExampleClassII(int aInstanceVariable)	{
	aInstanceVariable = aInstanceVariable;// local variable
	//this.aInstanceVariable =aInstanceVariable; //here the static variable will be changed
  }

  public static void methodInt(int aInt)	{
	aInt = 33;;
  }
  public static void methodIntArray(int array[])	{
	array[0] = 42;
  }
  public static void main(String args[] )	{
	ExampleClassII aExampleClassII = new ExampleClassII(3);
	methodInt(aInstanceVariable);
	methodIntArray(intArray);

	System.out.println("aInstanceVariable = " + aInstanceVariable);
	System.out.println("intArray[0] = " + intArray[0]);
  }
}