import java.net.*;
import java.util.Scanner;
import java.io.*;

class Struct implements Serializable {
    String str;
    char c;
    int i;

    Struct(String str, char c, int i) {
        this.str = str;
        this.c = c;
        this.i = i;
    }
}

class qn2cli1 {
    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println(">> Enter a string,  char, int value that will be sent to server:");
            String str = sc.nextLine();
            char c = sc.nextLine().charAt(0);
            int i = sc.nextInt();
            // float f = sc.nextFloat();

            Struct st = new Struct(str, c, i);

            System.out
                    .println(
                            ">> Sending object of class Struct to Server with values:" + st.str + " " + st.c + " "
                                    + st.i);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(st);

            byte[] buf = baos.toByteArray();

            InetAddress ip = InetAddress.getByName("127.0.0.1");

            DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress(ip, 1502));
            DatagramSocket ds = new DatagramSocket(null);
            ds.send(dp);

            System.out.println(">> Object sent to server");
            ds.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}