import java.util.*;

public class OverLoading {
    private static void display(int a){
        System.out.println("1 arg = "+a);
    }

    private static void display(int a, int b){
        System.out.println("2 arg = "+a+", "+b);
    }

    public static void main(String args[]){
        display(10);
        display(10, 20);
    }
}
