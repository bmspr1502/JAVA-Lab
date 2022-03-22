import java.util.*;

class MathOperations {
	public static void main(String args[]) {
		System.out.println("Enter two numbers: ");
		int one, two;

		Scanner sc = new Scanner(System.in);
		one = sc.nextInt();
		two = sc.nextInt();

		
		System.out.println("One = "+ one+ ", two = "+two);
		System.out.println("Difference = "+(one-two));
		System.out.println("Product = "+ (one*two));
		System.out.println("Sum = " +(one+two));
		System.out.println("quotient = "+(one/two));

	}
}
