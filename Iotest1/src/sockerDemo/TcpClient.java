package sockerDemo;


import java.io.*;
import java.net.Socket;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:44 18-10-3
 * @Modified: null
 */
public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8080);



        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        String message = "你好啊，服务端，我是客户端";
        printStream.println(message);

        System.out.println("向服务端发送消息："+message);

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = bufferedReader.readLine();
        System.out.println("收到服务器回应：" + line);


        socket.close();
    }
}
