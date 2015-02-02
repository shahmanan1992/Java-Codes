class Test {
        public static void main(String[] args) {
        	String other="Hello";
                String hello = "Hello", lo = "lo";
                System.out.print((hello == "Hello") + " ");
                System.out.print((hello == hello) + " ");
                System.out.print((other== hello) + " ");
                System.out.print((hello == ("Hel"+"lo")) + " ");
                System.out.println((hello == ("Hel"+lo)));
                System.out.println(hello == ("Hel"+lo).intern());
        }
}