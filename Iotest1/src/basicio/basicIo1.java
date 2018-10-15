package basicio;

import java.io.*;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午3:08 18-6-17
 * @Modified: 在电脑D盘下创建一个文件为HelloWorld.txt文件，
 * 判断他是文件还是目录，
 * 在创建一个目录IOTest,
 * 之后将HelloWorld.txt移动到IOTest目录下去；
 * 之后遍历IOTest这个目录下的文件
 */
public class basicIo1 {
    public static void main(String[] args) throws IOException {

        char[] chs = new char[100];

        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);

        File newfile = new File("Iotest1/src/HelloWorld.txt");

        if(!newfile.exists()){
            newfile.createNewFile();
        }
        OutputStream outputStream = new
                FileOutputStream(newfile);

        outputStream.write("我被复制了吗？".getBytes());

        outputStream.close();

        File newdir = new File("Iotest1/IOTest");

        if(!newdir.exists())
            newdir.mkdir();

        InputStream inputStream = new FileInputStream(newfile);

        File copyfile = new File(newdir,newfile.getName());
        OutputStream outputStream1 = new FileOutputStream(copyfile);

        byte[] bts = new byte[100];


        int len = 0;

        while((len = inputStream.read(bts)) != -1) {
            outputStream1.write(bts,0,len);
        }

        inputStream.close();
        outputStream1.close();

        File[] files = newdir.listFiles();

        for (File file :files ) {
            System.out.println(file.getName());
        }

    }
}
