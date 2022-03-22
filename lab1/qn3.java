import java.util.*;


class Number {
	public static void main(String args[]) {
		System.out.println("Enter a 5 digit number: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		if(!(num/10000 > 0 && num/10000<10)){
			System.out.println("Given number is not 5 digit");
		}else{
			System.out.println("i. " + num/10000);
			num = num%10000;
			System.out.println("ii. " + num/1000);
			num = num%1000;
			System.out.println("iii. " + num/100);
			num = num%100;
			System.out.println("iv. " + num/10);
			num = num%10;
			System.out.println("v. "+num);
		}
	}
}
