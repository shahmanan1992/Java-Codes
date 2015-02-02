class X_2 extends X_1 {

  public X_2()    {
	System.out.println("	in X_2!X_2()");
  }
  public void a()    {
	  super.a();
		System.out.println("    in X_1!a()");
  }

  public static void main(String args[])
  {
	X_2 aX_2 = new X_2();
	aX_2.a();
  }
}
