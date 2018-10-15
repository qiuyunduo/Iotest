package basicio;

import java.io.*;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午1:49 18-9-30
 * @Modified: null
 */
public class InputStreamDemo {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("Iotest1/src/HelloWorld.txt");


        byte[] bytes = new byte[1024];
        int a = 0;
        while ((a = inputStream.read(bytes))!=-1){
            System.out.println(bytes);
        }

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        String str = "";
//        while ((str = bufferedReader.readLine()) != null){
//            System.out.println(str);
//        }
    }
}
