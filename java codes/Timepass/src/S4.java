public class S4 {

  private int m1(int left, int right)	{
	while ( left != right )	{
		left  =  left > right ?  left - right :  left;
		right =  right > left ?  right - left :  right;
	}
			
	return left;
  }
  private int m2(int left, int right)	{
//	left = left < 0 ? -1 * left : left;
//	right = right < 0 ? -1 * right : right;
	if ( left == right )
		return left;
	if ( left > right )
		return m2(left - right, right );
	else
		return m2(right - left, left );
			
  }

  public static void main(String[] args) {
	//System.out.println(new S4().m1(85,35));
	System.out.println(new S4().m2(-85,35));
  }
}