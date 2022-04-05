public class Main {
    public static void main(String[] args) {
        String s1 = "Pranav";
        String s2 = "Pranav";
        String s3 = new String("Pranav");
        String s4 = s1.toLowerCase();

        System.out.println("s1==s2 " + (s1==s2));
        System.out.println("s1==s3 " + (s1==s3));
        System.out.println("s1.equals(s3) " + (s1.equals(s3)));
        System.out.println("s1.equals(s4) " + (s1.equals(s4)));
        System.out.println("s1.equalsIgnoreCase(s4) " + (s1.equalsIgnoreCase(s4)));
        
    }
}
