import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static char [] delim = {12};    
    public static String delimitter = new String(delim);
    public static String [] split(String full, String part){
        String newfull = full.replace(part, delimitter+part+delimitter);
        return newfull.split(delimitter);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your first string: ");
        String one = sc.nextLine();
        System.out.print("Enter your second string: ");
        String two = sc.nextLine();
        System.out.println(Arrays.toString(split(one, two)));
    }
    
}
