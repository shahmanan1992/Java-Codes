class Switch {

static void method(int k) {
	switch (k) {
	case 1:	 System.out.println("with break: 1 ");
		 break;
	case 2:	 System.out.println("with break: 2 ");
		 break;
	default: System.out.println("with break: default");
	}
}

static void methodWithoutDefault(int k) {
	switch (k) {
	case 1:	 System.out.println("	without break: 1 ");
		 break;
	case 2:	 System.out.println("	without break: 2 ");
		 break;
	}
}

public static void main(String[] args) {
	method(3);
	methodWithoutDefault(2);
	methodWithoutDefault(3);

  }
}