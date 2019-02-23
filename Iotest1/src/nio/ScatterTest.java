package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ScatterTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("Iotest1/IOTest/01.txt","rw");
        FileChannel channel = randomAccessFile.getChannel();

        ByteBuffer header = ByteBuffer.allocate(48);
        ByteBuffer body = ByteBuffer.allocate(1048);

        ByteBuffer[] arraryBuffers = {header,body};
        channel.read(arraryBuffers);
        header.flip();
        while (header.hasRemaining()){
            System.out.print(header.get());
        }
        System.out.println();
        body.flip();
        while (body.hasRemaining()){
            System.out.print(body.get());
        }

        header.capacity();
        body.capacity();
        RandomAccessFile randomAccessFile1 = new RandomAccessFile("Iotest1/IOTest/02.txt","rw");
        FileChannel channel1 = randomAccessFile.getChannel();
        channel1.write(arraryBuffers);


    }
}
