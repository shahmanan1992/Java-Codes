
class C extends AB {

  public C()	{
	System.out.println("    C()");
  }

  public int isAbstract()	{
	System.out.println("	C!isAbstract()");
	return 2;
  }

  public static void main(String args[] )	{
	B aB = new B();
	C aC = new C();

	aB.isAbstract();
	aC.isAbstract();

	(aB.concrete()).isAbstract();
	(aC.concrete()).isAbstract();

  }

}
