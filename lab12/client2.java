import java.io.*;
import java.net.*;

public class client2 {
    public static void main(String args[]) throws Exception {
        Socket s = new Socket("localhost", 1502);
        System.out.println("Connected Successfully");

        DataInputStream din = new DataInputStream(s.getInputStream());

        String str1 = din.readUTF();
        System.out.println("Recevied Input: " + str1);

        din.close();
        System.out.println("Closing the connection");
        s.close();
    }
}