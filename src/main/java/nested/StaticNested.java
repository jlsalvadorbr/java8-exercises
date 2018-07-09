package nested;

//Top-level class nested in another top-level class for packaging convenience
public class StaticNested {
	
	private String label = "Outer class";
	
	static class Nested {

		public void showLabel() {
			//System.out.println(label); //cannot refer to instance variables or methods (unless trough an object reference)
			System.out.println("Nested label");
		}
	}
	
	public static void main(String[] args) {
		Nested nested = new StaticNested.Nested();
		nested.showLabel();
	}
}
