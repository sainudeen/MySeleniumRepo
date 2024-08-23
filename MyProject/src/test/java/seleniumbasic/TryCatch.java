package seleniumbasic;

public class TryCatch {

	void divide(int a, int b) {
		// performing divison and storing th result

		int res = a / b;

		
		  System.out.println("Division process has been done successfully.");
		  System.out.println("Result came after division is: " + res);
		  
		 

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TryCatch obj = new TryCatch();
		try {
			obj.divide(10, 0);
		} 
		
		catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception Arithmatic arent block");
			e.printStackTrace();
		}
		
		

		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception Parent block");
			e.printStackTrace();
		}
		
	}

}
