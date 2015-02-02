class Q	{

  public int instanceV = 1;		

  public void both()    {
        instanceV = 200;
  }

  public String toString()	{
	return "Question_91_5b: " + instanceV;
  }
  public static void main(String args[]) {
	System.out.println(new Q());
  }
}

/*
Question_91_5b: 1
*/