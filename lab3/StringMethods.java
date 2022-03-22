import java.util.Scanner;

public class StringMethods {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        System.out.println(x.charAt(3));
        String y = "Hello";
        System.out.println(x.compareTo(y));
        System.out.println(x.concat(y));
        System.out.println(x.endsWith("ld"));
        System.out.println(x.indexOf("a"));
        sc.close();

    }
}
