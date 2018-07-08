package nested;

public class InnerLocal {
	
	public static final String UNALLOWED_CHARS_REGEX = "[^0-9]"; //must be static to be accessible from a static method
	
	public static void convertToNumber(String number1, String number2)
	{
		String label = "Formatted number: "; //effectively final (needs "final" before Java 8 to be used whithin the local class)
		
		class NumberFormatter {
			
			String formattedNumber;
			//static int version = 1; //local classes (same as inner classes) cannot have static members (including methods);
			final static int version = 1;
			
			NumberFormatter(String numberString)
			{
				formattedNumber = numberString.replaceAll(UNALLOWED_CHARS_REGEX, ""); 
			}

			public String getFormattedNumber() {
				//label += " ";  //not effectively final
				return label + formattedNumber;
			}
			
			public String getFormattingRequest() {
				return number1 + " / " + number2; //method params only accessible from Java8
			}
		}
		
		NumberFormatter nf1 = new NumberFormatter(number1);
		NumberFormatter nf2 = new NumberFormatter(number2);
		
		System.out.println("Formatting request: " + nf1.getFormattingRequest());
		
		System.out.println(nf1.getFormattedNumber());
		System.out.println(nf2.getFormattedNumber());
		
		System.out.println("NumberFormatter version: " + nf1.version);
	}
	
	public static void main(String[] args)
	{
		InnerLocal innerLocal = new InnerLocal();
		innerLocal.convertToNumber("1-2---3", "@1,.2--3  4");
	}

}
