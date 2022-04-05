import java.util.*;

public class Airline {

    private static boolean capacity[] = new boolean[10];
    public static void print(String x){
        System.out.print(x);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        do{
            print("Enter your preferred class: (1-firstclass), (2-economy), (others-exit): ");
            int n = sc.nextInt();
            if(n!=1||n!=2){
                
            }
        }while(true);
    }
    
}
