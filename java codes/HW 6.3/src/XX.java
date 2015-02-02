public class  XX  extends X {

        static int staticX = 0;
        int instanceX = 0;

        public XX(int i)    {
		staticX   = i;
		instanceX = i * 2;
        }
        public String  toString(){
		return "X: staticX/instanceX = " + staticX + "/" + instanceX;
  	}
        static public void sMethod(int i){
		staticX   += i;
		System.out.println("sMethod="+ staticX);
	}
        public static void iMethod(int i){
		staticX   += i;
		System.out.println("iMethod="+ staticX);
        }
        public void iMethodX(int i){
		staticX   += i;
		instanceX += i * 2;
		System.out.println("iMethodX="+ staticX);
		System.out.println("iMethodX="+ instanceX);
        }
        public void iMethodXX(int i){
		staticX   += i;
		instanceX += i * 2;
		System.out.println("iMethodXX="+ staticX);	
		System.out.println("iMethodXX="+ instanceX);
        }
        public static void main(String args[] )       {
		X   aX1 = new X(1);
		X   aX2 = new XX(2);
		XX aXX1 = new XX(3);
			
		aX1.sMethod(4);
		aX1.iMethodX(5);
		//aX1.iMethodXX(6);

		aX2.sMethod(7);
		aX2.iMethodX(8);
		//aX2.iMethodXX(9);

		/*aXX1.sMethod(10);
		aXX1.iMethodX(11);
		aXX1.iMethodXX(11);

		aX1 = aXX1;
		aX1.sMethod(4);
		aX1.iMethodX(5);
	    aX1.iMethodXX(6);*/
        }
}