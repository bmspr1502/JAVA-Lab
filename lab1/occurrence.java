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
			
			if(array[i]>max)
				max = array[i];
		}
		
		System.out.println("Maximum element of the array: " + max);
		
		int freq[] = new int[max];
		
		for(int i=0; i<n; i++){
			freq[array[i]-1]++;
		}
		
		System.out.println("\nFrequency of elements: ");
		for(int i=0; i<max; i++){
			if(freq[i]>0){
				System.out.println((i+1)+" = "+freq[i]);
				}
			}
		
	}
}
