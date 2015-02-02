class Break_2 {

  public static void main( String args[] ) {
    
        int n = 0;

	System.out.println("start");
        while ( n < 100 )  {
                if ( n > 4 )
                        System.exit(1);

                while ( n < 100 )  { 	// while ( true ) --> which problem
                        n++;
			System.out.println("	inner while here n == " + n);
			if ( n > 2 )
				break;
                }
		System.out.println("outer while here n == " + n);
           }
	System.out.println("after here }");
  }
}