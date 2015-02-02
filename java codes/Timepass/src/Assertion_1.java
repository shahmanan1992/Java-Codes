/*
 * Execetion: java -ea Assertion_1
 */
public class Assertion_1 {
	public void method( int value ) {
		assert true;
		System.out.println("asertM ---->");
		System.out.println("\tvalue = " + value );
		System.out.println("asertM <----");
	}

	public static void main( String[] args ) {
		Assertion_1 asertM = new Assertion_1();
		asertM.method( 1 );
		asertM.method( -1 );
	}
}