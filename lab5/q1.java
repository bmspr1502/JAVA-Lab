public class DCSE {
    public static void main(String[] args) {
        String dc = "Department of Computer Science and Engineering";
        char outString[] = new char[dc.length()];
        int j = 0;
        for(int i=0; i<dc.length(); i++){
            char x = dc.charAt(i);

            if(x>='A' && x<='Z'){
                outString[j]=x;
                j++;
            }
        }

        System.out.println(dc + " = " + new String(outString));
    }
}
