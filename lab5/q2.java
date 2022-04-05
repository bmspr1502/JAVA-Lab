import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String x = "This is an example Sentence buhahaha";

        String[] words = x.split("[ .,\t\n]");
        int n = words.length;
        System.out.println("\"" + x + "\" contains " + n + " words.\n Reverse string = ");
        for(int i=0; i < n/2; i++){
            String tmp = words[i];
            words[i] = words[n-1-i];
            words[n-1-i] = tmp;
        }
        System.out.println(Arrays.toString(words));
    }
}
