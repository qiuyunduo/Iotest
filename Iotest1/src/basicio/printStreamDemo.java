package basicio;

import java.io.*;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午6:07 18-10-2
 * @Modified: null
 */
public class printStreamDemo {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("Iotest1/src/HelloWorld1.txt");
//        Writer writer = new OutputStreamWriter(outputStream);
//        PrintWriter pr = new PrintWriter(writer);
//
//        pr.print("我是利用PrintWrite写入的数据");


        PrintStream pr = new PrintStream(outputStream);

        pr.print("asdasdsadasdsadasda");

        pr.flush();
        pr.close();

        outputStream.close();
    }
}
