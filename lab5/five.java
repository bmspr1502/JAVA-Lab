import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String S = "Pranava Raman B M S";
        byte[] byteArray;
        byteArray = S.getBytes();

        System.out.println(S + " = " + Arrays.toString(byteArray));
    }
}
