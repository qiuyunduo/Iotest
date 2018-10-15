package sockerDemo;

import java.io.IOException;
import java.net.*;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:14 18-10-3
 * @Modified: null
 */
public class UdpServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(5555);
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf,buf.length);

        packet.setPort(5556);
        packet.setAddress(InetAddress.getLocalHost());
        packet.setData("hello 5556 port".getBytes());

        socket.send(packet);
        System.out.println("port 5555 send:"+new String(packet.getData()));
        socket.receive(packet);
        System.out.println("port 5555 recive:"+new String(packet.getData()));
        socket.close();
    }
}