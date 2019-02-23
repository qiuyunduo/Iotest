package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class SelectoryTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("Iotest1/IOTest/01.txt","rw");

        Selector selector = Selector.open();
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress(8088));
        channel.configureBlocking(false);
        SelectionKey selectionKey = channel.register(selector,SelectionKey.OP_READ);

        while (true){
            int readChannels = selector.select();
            if(readChannels == 0) continue;
            Set selectKeys = selector.selectedKeys();
            Iterator iterator = selectKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = (SelectionKey) iterator.next();
                if(key.isAcceptable()) {
                    System.out.println("a connection was accept by a ServerSocketChannel");
                } else if(key.isConnectable()) {
                    System.out.println("a connection was established by a ServerSocketChannel");
                } else if(key.isReadable()) {
                    System.out.println("a channel is ready to reading");
                } else if(key.isWritable()) {
                    System.out.println("a channel is ready to writing");
                }

                iterator.remove();
            }

        }
    }
}
