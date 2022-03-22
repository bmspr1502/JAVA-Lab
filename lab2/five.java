import java.util.*;
public class five{
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of elements in the array: ");
		n = sc.nextInt();
		int arr[] = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		int max = arr[0];
		for(int x: arr){
			if(x>max)
				max = x;
		}
		System.out.println("The max = " + max);
	}
}