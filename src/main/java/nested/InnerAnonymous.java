package nested;

//Declare and instantiate a class at the same time
//Same as Local classes except they do not have a name (useful if only needed once)
//Same access to local vairables of the cnclosing scope
//Expressions, not declarations (as Local classes)
public class InnerAnonymous {

	interface BinaryIntOperation {
		int operate(int op1, int op2); //public
	}
	
	public void operate() {
		
		int MAX_SUM_NUMBER = 1000; //effectively final (needs "final" before Java 8 to be used whithin the local class)
		
		BinaryIntOperation sumInts = new BinaryIntOperation() {
			public int operate (int op1, int op2) {
				//MAX_SUM_NUMBER++; //not effectively final
				if (op1 > MAX_SUM_NUMBER || op2 > MAX_SUM_NUMBER)
				{
					throw new RuntimeException("Max Int allowed is: " + MAX_SUM_NUMBER);
				}
				return op1 + op2;
			}
		};
		
		BinaryIntOperation multiplyInts = new BinaryIntOperation() {
			//static int MAX_FACTOR NUMBER = 100000;  //local classes (same as inner classes) cannot have static members (including methods);
			final static int MAX_FACTOR_NUMBER = 100000;
			
			public int operate (int op1, int op2) {
				if (op1 > MAX_FACTOR_NUMBER || op2 > MAX_FACTOR_NUMBER)
				{
					throw new RuntimeException("Max Int allowed is: " + MAX_FACTOR_NUMBER);
				}
				return op1 * op2;
			}
		};
		
		System.out.println(sumInts.operate(2,3));
		System.out.println(multiplyInts.operate(2,3));
	}
	
	public static void main(String[] args) {
		InnerAnonymous ia = new InnerAnonymous();
		ia.operate();
	}

}
