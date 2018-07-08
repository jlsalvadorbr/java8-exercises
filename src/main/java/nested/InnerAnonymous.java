package nested;

public class InnerAnonymous {
	
	interface BinaryIntOperation {
		String label = "Operation: "; //static final
		int operate(int op1, int op2); //public
	}
	
	public void operate() {
		
		BinaryIntOperation sumInts = new BinaryIntOperation() {
			public int operate (int op1, int op2) {
				return op1 + op2;
			}
		};
		
		BinaryIntOperation multiplyInts = new BinaryIntOperation() {
			public int operate (int op1, int op2) {
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
