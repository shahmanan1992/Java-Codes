
public class Tp {
	public static void main(String args[])
	{
		String s1="example";
		String s2=new String("example");
		String s3=s1.intern();
		System.out.println(s1==s3);
	}
}
