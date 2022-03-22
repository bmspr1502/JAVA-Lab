import java.util.*;

public class Employee{

	public static void bubbleSort(int work[][], int sum[], int n){
		for(int i=0; i<n; i++){
			for(int j=0; j<n-1-i; j++){
				if(sum[j]>sum[j+1]){
					int temp[] = work[j];
					work[j]=work[j+1];
					work[j+1] = temp;
					
					int tmp = sum[j];
					sum[j] = sum[j+1];
					sum[j+1] = tmp;
				}
			}
		}
	}
	public static void main(String args[]){

		int work[][] = {
			{5,4,3,1,6,3,7},
			{6,3,2,8,7,1,7},
			{9,5,4,3,4,2,1},
			{6,6,6,6,6,6,6},
			{5,3,5,6,4,8,9},
			{1,2,3,4,5,6,7},
			{7,3,2,4,2,3,4},
		};
		
		int sum[] = new int[7];
		

		
		for(int i=0; i<sum.length; i++){
			sum[i]=0;
			for(int j=0; j<7; j++){
				sum[i]+=work[i][j];
			}
		}
		System.out.println("\n1\t2\t3\t4\t5\t6\t7\tTotal");
		System.out.println("==================================================\n");
		
		for(int i=0; i<sum.length; i++){
			
			for(int j=0; j<7; j++){
				System.out.print(work[i][j]+"\t");
			}
			System.out.println(sum[i]);
		}
		
		System.out.println("Sorting...\n");
		bubbleSort(work, sum, 7);
		
				System.out.println("\n1\t2\t3\t4\t5\t6\t7\tTotal");
		System.out.println("==================================================\n");
		
		for(int i=0; i<sum.length; i++){
			
			for(int j=0; j<7; j++){
				System.out.print(work[i][j]+"\t");
			}
			System.out.println(sum[i]);
		}
		
		
		
	}
}
