import java.io.*;
import java.net.*;

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

class qn2cli2 {
    public static void main(String[] args) throws Exception {
        try {
            DatagramSocket ds = new DatagramSocket(15021);

            byte[] recvBuf = new byte[5000];
            DatagramPacket packet = new DatagramPacket(recvBuf, recvBuf.length);
            ds.receive(packet);

            int byteCount = packet.getLength();
            ByteArrayInputStream byteStream = new ByteArrayInputStream(recvBuf);
            ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(byteStream));
            Struct o = (Struct) is.readObject();

            System.out.println("<< Object received from Server with values: " + o.str + " " + o.c + " " + o.i);

            ds.close();
            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}