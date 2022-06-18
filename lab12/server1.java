import java.io.*;
import java.net.*;

class Struct implements Serializable {
    public int number;
    public float f;
    public char ch;

    public Struct(int n, float m, char o) {
        number = n;
        f = m;
        ch = o;
    }
}

public class server1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(35013);

        byte[] recvBuf = new byte[5000];
        DatagramPacket packet = new DatagramPacket(recvBuf, recvBuf.length);
        ds.receive(packet);

        int byteCount = packet.getLength();
        ByteArrayInputStream byteStream = new ByteArrayInputStream(recvBuf);

        ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(byteStream));

        Object o = is.readObject();

        Struct st = (Struct) o;
        System.out.println(st.ch);
    }
}