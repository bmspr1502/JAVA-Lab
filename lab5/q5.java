import java.util.Scanner;

public class Main {

    public static String reverseCase(String input){
        char[] sequence = new char[input.length()];

        for(int i=0; i<input.length(); i++){
            char x = input.charAt(i);

            if(x>='A' && x<='Z'){
                sequence[i] = (char) ((int)x-65+97);
            }else if(x>='a'&&x<='z'){
                sequence[i] = (char) ((int)x-97+65);
            }else{
                sequence[i] = x;
            }

        }

        return new String(sequence);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your string: ");
        String iString = sc.nextLine();

        System.out.println(reverseCase(iString));
    }
}
