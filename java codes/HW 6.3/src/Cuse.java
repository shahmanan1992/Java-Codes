interface C extends A,B {

	int AB = 1;
	// Attempt to reference field AB in a int.

        public void c();
}

interface B {

	static int B  = 2;
	int AB = 52;

        public void b();
}

interface A {

	static int A  = 1;
	int AB = 5;

        public void a();
}

public class Cuse implements C {

    public void a() {
	System.out.println("CUse!a");
	// System.out.println("B  = " + A.AB);
    }

    public void b() {
	System.out.println("CUse!b");
    }
    public void c() {
	System.out.println("CUse!c");
    }

    public static void main(String argv[])	{
	new Cuse().a();
	System.out.println("A  = " + AB);
	System.out.println("B  = " + AB);
    }
}
