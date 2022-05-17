import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringReader;
import java.util.Scanner;

class Telephone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            FileWriter writer = new FileWriter("telephonedir.txt");

            do{
                System.out.println("Enter Phone Number (enter 0 to stop): ");
                String number = sc.nextLine();
                if(number.equals("0"))
                    break;

                System.out.println("Enter Name: ");
                String name = sc.nextLine();


                writer.write(name + "       "+number+"\n");
            }while(true);

            writer.close();
        }catch(Exception e){
            System.out.println(e);
        }
        sc.close();
    }
    
}
