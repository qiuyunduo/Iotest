package basicio;

import java.io.*;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午2:49 18-9-30
 * @Modified: null
 */
public class OutputStreamDemo {
    public static void main(String[] args) throws IOException{
        OutputStream outputStream = new FileOutputStream("Iotest1/src/HelloWorld1.txt");
//        outputStream.write("hello".getBytes());
//        outputStream.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello world");
        bufferedWriter.write("\n");
        bufferedWriter.write("你好，世界");


        bufferedWriter.close();
        outputStream.close();
    }
}
