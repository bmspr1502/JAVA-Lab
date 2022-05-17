import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class TelephoneReader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name to change the phone number: ");
        String changename = sc.nextLine();

        boolean found = false;

        try{

            File filein = new File("telephonedir.txt");
           
            Scanner input = new Scanner(filein);
            File fileout= new File("temp.txt");
            PrintWriter output = new PrintWriter(fileout);
            
            while(input.hasNext()){
                String currline = input.nextLine();
                

                String[] details = currline.split("       ");

                System.out.println("Current Line = " + details[0] + "," + details[1]);
                if(details[0].equals(changename)){
                    System.out.println("Enter the changed Phone number: ");
                    String changenum = sc.nextLine();

                    output.println(changename + "       " + changenum);
                    found = true;
                }else{
                    output.println(currline);
                }

            }

            output.close();
            input.close();

            if(filein.delete()){
                if(fileout.renameTo(new File("telephonedir.txt"))){
                    System.out.println("File Updated");
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        sc.close();
    }
}
