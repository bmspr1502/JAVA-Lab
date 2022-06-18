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

class qn2serv {
    public static void main(String[] args) throws Exception {
        try {
            DatagramSocket ds = new DatagramSocket(1502);

            byte[] recvBuf = new byte[5000];
            DatagramPacket packet = new DatagramPacket(recvBuf, recvBuf.length);
            ds.receive(packet);

            int byteCount = packet.getLength();
            ByteArrayInputStream byteStream = new ByteArrayInputStream(recvBuf);
            ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(byteStream));
            Struct o = (Struct) is.readObject();

            System.out.println("<< Object received from Client 1 with values: " + o.str + " " + o.c + " " + o.i);

            ds.close();
            is.close();

            Struct st = new Struct(o.str + "+extradata", (char) (o.c + 1), o.i + 1);

            System.out.println(
                    ">> Sending object of class Struct to Client 2 with values:" + st.str + " " + st.c + " " + st.i);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(st);

            byte[] buf = baos.toByteArray();

            InetAddress ip = InetAddress.getByName("127.0.0.1");

            DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress(ip, 15021));
            DatagramSocket dsock = new DatagramSocket(null);
            dsock.send(dp);

            System.out.println(">> Object sent to Client 2");
            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}