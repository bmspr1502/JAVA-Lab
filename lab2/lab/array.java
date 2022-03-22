import java.util.*;

public class arrays{
	public static void main(String args[]){
		int arr[] = { 5,3,2,8, 9, 10, 32};
		
		System.out.println("arr.length = " + arr.length);
		
		//int newArr[] = new int[arr.length];
		int newArr[] = Arrays.copyOf(arr, arr.length);
		System.out.println("newArr = Arrays.copyOf(arr, length): ");
		System.out.println("Arrays.toString(newArr): "+Arrays.toString(newArr));
		Arrays.sort(newArr);
		System.out.println("Arrays.sort(newArr): "+Arrays.toString(newArr));
		System.out.println("Arrays.binarySearch(newArr, 9): " + Arrays.binarySearch(newArr, 9));
		System.out.println("Arrays.compare(newArr, arr): "+ Arrays.compare(newArr, arr));
		System.out.println("Arrays.equals(newArr, arr): "+ Arrays.equals(newArr, arr));
	}
}
