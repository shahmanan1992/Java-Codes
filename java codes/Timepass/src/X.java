      public class  X {
        static int cI = 0;
        int oI = 1;

        public X()    {
        }
        static public void cm(int i){
              cI = i;
              
              System.out.println("cm: " + cI );
        }
        public void om(int i){
              cI = i;
              oI = i;
              System.out.println("om: " + this);
              System.out.println("    cI " + cI);
              System.out.println("    oI " + oI);
        }

        public static void main(String args[] )       {
              X aX = new X();
              X aaX = new X();

              aX.cm(1);
              aaX.cm(2);

              aX.om(3);
              aaX.om(4);
        }
      }