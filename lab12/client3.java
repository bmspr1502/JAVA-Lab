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

public class client3 {

    public static void main(String[] args) throws Exception {
        Struct st = new Struct(1, 2, 'f');

        InetAddress address = InetAddress.getByName("localhost");
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(35013);
        ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(byteStream));

        os.flush();
        os.writeObject(st);

        byte[] sendBuf = byteStream.toByteArray();
        DatagramPacket packet = new DatagramPacket(sendBuf, sendBuf.length, address, 35013);

        int byteCount = packet.getLength();
        DatagramSocket ds = new DatagramSocket(35015);
        ds.send(packet);
        os.close();

    }
}