public class  X {
        static int staticX = 0;
        int instanceX = 0;

        public X()    {		// why is this one needed?
        }
        public X(int i)    {
		staticX   = i;
		instanceX = i * 2;
        }
        public String  toString(){
		return "X: staticX/instanceX = " + staticX + "/" + instanceX;
  	}
        static public void sMethod(int i){
		staticX   += i;
		System.out.println("Base sMethod");
	}
        public static void iMethod(int i){
		staticX   += i;
		System.out.println("Base iMethod");
        }
        public void iMethodX(int i){
		staticX   += i;
		instanceX += i * 2;
		System.out.println("Base iMethodX");
        }
        public static void main(String args[] )       {
        }
}