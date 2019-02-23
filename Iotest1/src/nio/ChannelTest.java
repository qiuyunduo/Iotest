package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ChannelTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("Iotest1/IOTest/01.txt","rw");

        //nio写操作
        FileChannel  writeChannel = randomAccessFile.getChannel();
        String newData = "New String to write to file ..." + System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.wrap(newData.getBytes("utf-8"));
        buffer.flip();
        while (buffer.hasRemaining()){
            writeChannel.write(buffer);
        }
//        writeChannel.close();
        //nio读操作
        FileChannel  readChannel = randomAccessFile.getChannel();
        ByteBuffer buffer1 = ByteBuffer.allocate(48);

        int read = readChannel.read(buffer1);
        buffer1.flip();
        System.out.println(read);
//        System.out.println(buffer1);
//        Charset charset = Charset.forName("utf-8");
//        CharsetDecoder charsetDecoder = charset.newDecoder();
//        CharBuffer decode = charsetDecoder.decode(buffer1);
//        System.out.println(decode.toString());

        while(buffer1.hasRemaining()){
            System.out.print((char)buffer1.get());
        }
        readChannel.close();
    }

}
