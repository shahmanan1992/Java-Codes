class StringCast {
public static void main(String args[])
{
	Object o=42;
	String s=(String)o;
	String a=String.valueOf(o);
	System.out.println(s);
	System.out.println(a);
}
}
