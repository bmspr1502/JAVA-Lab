import java.util.*;


class Sorting{
	public static void main(String args[]){

		System.out.println("Enter length of array: ");
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int array[] = new int[n];
		System.out.println("\nEnter elements of array: ");
		for(int i=0; i<n; i++){
			System.out.println("array["+i+"] = ");
			array[i] = sc.nextInt();
		}
		
		
		for(int i = 0; i<n; i++){
			for(int j=0; j<n-i-1; j++){
				if(array[j]>array[j+1]){
				int tmp = array[j];
				array[j]=array[j+1];
				array[j+1] = tmp;				
				}
			}
		}
		
		System.out.println("Sorted array ");
		for(int i=0; i<n; i++){
			System.out.println("array["+i+"] = " + array[i]);
		}
	}
}
