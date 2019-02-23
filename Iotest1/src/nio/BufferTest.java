package nio;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class BufferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("Iotest1/IOTest/01.txt","rw");

        FileChannel fileChannel = randomAccessFile.getChannel();

        //分配缓存区的大小
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int byteRead = fileChannel.read(buffer);

        while (byteRead != -1){
            System.out.println("read "+byteRead);
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.print((char)buffer.get());
            }

            buffer.clear();
            byteRead = fileChannel.read(buffer);
        }
        randomAccessFile.close();
    }



}
