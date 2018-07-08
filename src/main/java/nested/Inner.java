package nested;

public class Inner {
	
	private final static int NUMBERS_SIZE = 24; // 0-23
	private int[] numbers = new int[NUMBERS_SIZE];
	
	public Inner() {
		for (int i=0; i < NUMBERS_SIZE; i++)
		{
			numbers[i] = i;
		}
	}
	
	public void printEven() {
		EvenNumberIterator it = this.new EvenNumberIterator();
		while (it.hasNext())
		{
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}
	
	interface EvenIterator extends java.util.Iterator<Integer>{}
	
	private class EvenNumberIterator implements EvenIterator {
		
		private int index = 0;

		@Override
		public boolean hasNext() {
			return (index <= NUMBERS_SIZE - 1);
		}

		@Override
		public Integer next() {
			Integer nextNumber = Integer.valueOf(numbers[index]);
			index += 2;
			return nextNumber;
		}
	}
	
	public static void main(String s[]) {
		Inner inner = new Inner();
		inner.printEven();
	}
}
