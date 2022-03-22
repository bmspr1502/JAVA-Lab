import java.util.*;

public class freq{

	public static boolean doesExist(int arr[], int l, int x){
		for(int i=0; i<l; i++){
			if(arr[i]==x)
				return true;
		}
		return false;
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter elements: ");
		
		int arr[] = new int [5];
		int x = 0;
		for(int i=0; i<5; i++){
			int n = sc.nextInt();
			if(!doesExist(arr, x, n)){
				arr[x] = n;
				x++;
			}
		}
		
		System.out.println("Unique elements: ");
		
		for(int i=0; i<x; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println(" ");
		
	}
}
