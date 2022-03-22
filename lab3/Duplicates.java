import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Duplicates {

    public static void print(String arg){
        System.out.print(arg);
    }
    private static int[] removeDuplicates(int arr[]){

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int x: arr){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int newArr[] = new int[map.size()];
        int i = 0;
        for(int x: arr){
            if(map.get(x)>0){
                newArr[i] = x;
                i++;
                map.put(x, 0);
            }
        }
      
        return newArr;
    };

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        print("Enter number of elements: ");        
        int n = sc.nextInt();
        int[] arr = new int[n];
        print("\nEnter elements: \n");

        for(int i = 0; i<n; i++){
            print("Arr["+i+"] = ");
            arr[i] = sc.nextInt();
        }

        print(Arrays.toString(removeDuplicates(arr)) + "\n");
        sc.close();
    }
}
