
class B extends AB {

  public B()	{
	System.out.println("    B()");
  }

  public int isAbstract()	{
	System.out.println("	B!isAbstract()");
	return 1;
  }

//  public AB concrete()	{
//	System.out.println("B!concrete()");
//	return this;
//  }

}
