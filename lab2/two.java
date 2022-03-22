import java.util.*;

public class two{
	public static void main(String args[]) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of elements in the array: ");
		n = sc.nextInt();
		int arr[] = new int[n];
		int sum = 0;
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
			sum+=arr[i];
		}

		System.out.println("The sum = " + sum);
	}
}
