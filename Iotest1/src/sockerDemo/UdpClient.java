package sockerDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:14 18-10-3
 * @Modified: null
 */
public class UdpClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(5556);
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        packet.setPort(5555);
        packet.setAddress(InetAddress.getLocalHost());
        packet.setData("hello 5555 port".getBytes());

        socket.send(packet);
        System.out.println("port 5556 send:"+new String(packet.getData()));
        socket.receive(packet);
        System.out.println("port 5556 recive:"+new String(packet.getData()));
        socket.close();
    }
}
