package sockerDemo;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:44 18-10-3
 * @Modified: null
 */
public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        PrintStream printStream = new PrintStream(outputStream);

        String line = reader.readLine();
            System.out.println("收到客户端发送的内容: " + line);

        String rmessage = "你好啊，客户端，我是服务端";
        printStream.print(rmessage);
        System.out.println("服务端回应的内容为："+rmessage);

        socket.close();

    }
}
