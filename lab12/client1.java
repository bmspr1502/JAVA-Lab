import java.io.*;
import java.net.*;
import java.util.*;

public class client1 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Input : ");
        String ch = sc.nextLine();
        Socket s = new Socket("localhost", 1502);
        System.out.println("Connected Successfully");

        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        System.out.println("Sending " + ch);

        dout.writeUTF(ch);

        din.readUTF();
        System.out.println("Closing the connection");
        dout.flush();
        dout.close();
        s.close();
        sc.close();
    }
}