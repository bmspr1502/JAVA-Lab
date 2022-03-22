import java.util.*;

public class two{
	public static void main(String args[]) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the marks :");
		n = sc.nextInt();

		if(n>=50)
			System.out.println("Pass");
		else if(n>=40)
			System.out.println("Just Pass");
		else
			System.out.println("Fail");
	}
}
