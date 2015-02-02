abstract class A {

  public int x;		

  abstract public A a(int x);

  public A aa(int x)	{
	System.out.println("    in A!aa");
	return this;
  }

}