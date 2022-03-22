import java.util.*;

class Rectangle {
	public static void main(String args[]) {
		System.out.println("Enter length of the rectangle: ");
		Scanner sc = new Scanner(System.in);

		float l = sc.nextFloat();
		System.out.println("Enter breadth of the rectangle: ");
		float b = sc.nextFloat();

		
		System.out.println("Perimeter = "+ (2*(l+b))+ ", Area = "+(l*b));

	}
}
