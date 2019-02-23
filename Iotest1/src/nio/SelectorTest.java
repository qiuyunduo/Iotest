package nio;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;

public class SelectorTest {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.accept();

    }
}
