import java.util.*;


class Occurrence{
	public static void main(String args[]){
		System.out.println("Enter the number of elements: ");
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int array[] = new int[n];
		
		int max = 0;
		System.out.println("\nEnter elements of array: ");
		for(int i=0; i<n; i++){
			System.out.println("array["+i+"] = ");
			array[i] = sc.nextInt();
		}
		
		for(int i=0; i<n/2; i++){
			int tmp = array[i];
			array[i] = array[n-1-i];
			array[n-1-i] = tmp;
		}
	
		System.out.println("\nReversed array: ");	
		for(int i=0; i<n; i++){
			System.out.println("array["+i+"] = " + array[i]);
		}
	}
}
