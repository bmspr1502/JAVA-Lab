import java.util.*;

class Calc {
	public static void main(String args[]){
		System.out.println("CALCULATOR");
		System.out.println("1.ADD\n2.SUB\n3.MULT\n4.DIV");
		System.out.println("Enter your choice :");
		
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
		float one = 0, two=1;
		if(ch>0){
		System.out.println("Enter first:");
		one = sc.nextFloat();
		System.out.println("Enter second:");
		two = sc.nextFloat();
		}
		switch(ch){
			case 1: System.out.println("Sum = " + (one+two));
					break;
			case 2:	System.out.println("Difference = " + (one-two));
					break;
			case 3: System.out.println("Mult = " + (one*two));
					break;
			case 4:	System.out.println("Div = " + (one/two));
					break;
			default:
					break;
		}
		
	}
}
