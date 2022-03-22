import java.util.Scanner;

public class Comparing {
    public static boolean compareTo(double a, double b){
        return (a==b);
    }

    public static void print(String arg){
        System.out.print(arg);
    }

    public static boolean compareTo(String a, String b){

        if(a.length() > b.length())
            return false;
        boolean flag = false;
        for(int i=0; i<b.length(); i++){
            flag = true;
            for(int j = 0; j<a.length() && (i+j)<b.length(); j++){
                if(a.charAt(j)==b.charAt(i+j)){
                    continue;
                }else{
                    flag = false;
                }
            }

            if(flag==true)
                return flag;
        }

        return flag;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int ch;
        print("\nEnter 1 for double value checking and 2 for String value compare: \n");
        ch = sc.nextInt();
        sc.nextLine();

        if(ch==1){
            print("Enter first value: ");
            double x = sc.nextDouble();
            print("Enter second value: ");
            double y = sc.nextDouble();

            if(compareTo(x, y)){
                print("\nThey both are equal\n");
            }else{
                print("\nThey both are not equal\n");
            }
        }else{
            print("Enter first string: ");
            String x = sc.nextLine();
            print("Enter second string: ");
            String y = sc.nextLine();

            if(compareTo(x, y)){
                print("\nFirst line is substring of second\n");
            }else{
                print("\nFirst line is not a substring of second\n");
            }
        }
        sc.close();
    }
}
