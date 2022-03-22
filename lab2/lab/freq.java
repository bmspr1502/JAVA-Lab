import java.util.*;

public class freq{
	public static boolean isPattern(int arr[]){
		int x = 0, curr = arr[0];
		for(int a: arr){
			if(a==curr){
				x++;
			}
			else{
				curr = a;
				x=0;
			}	
			if(x>=4)
				return true;
			
		}
		
		
		return false;
	}
	public static void main(String args[]){
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no. of elements: ");
		n = sc.nextInt();
		
		System.out.println("Enter elements: ");
		
		int arr[] = new int [n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		
		if(isPattern(arr)){
			System.out.println("Follows the pattern");
		}else{
			System.out.println("Doesn't follow the pattern");
		}
	}
}
