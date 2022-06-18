import java.io.*;
import java.net.*;

class server {
    public static void main(String args[]) throws Exception {

        int port = 1502;
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server listening on port : " + port);

        Socket client1 = ss.accept();
        System.out.println("First Clients Connected");

        DataOutputStream dout1 = new DataOutputStream(client1.getOutputStream());
        DataInputStream din = new DataInputStream(client1.getInputStream());
        String str = din.readUTF();
        System.out.println("client says: " + str);

        Socket client2 = ss.accept();
        DataOutputStream dout = new DataOutputStream(client2.getOutputStream());
        int res = (int) str.charAt(0);

        char ch = (char) (res - 1);

        String str2 = "" + ch;
        System.out.println("Sending: " + str2);

        dout.writeUTF(str2);

        dout.flush();
        dout1.writeUTF("close");
        din.close();
        System.out.println("Closing the connection of 2 clients");
        client1.close();
        client2.close();
        ss.close();

    }
}