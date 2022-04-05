import java.util.*;
public class Main {

    public static String longestCommonPrefix(String one, String two){
        int length = (one.length() < two.length())?one.length():two.length();
        int res = 0;
        for(int i=0; i<length; i++){
            if(one.charAt(i)==two.charAt(i)){
                res++;
            }else{
                break;
            }
        }

        return one.substring(0, res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your first string: ");
        String one = sc.nextLine();
        System.out.print("Enter your second string: ");
        String two = sc.nextLine();

        System.out.println("Longest Common Prefix of " + one +" , " + two + " = " + longestCommonPrefix(one, two));
    }
}
