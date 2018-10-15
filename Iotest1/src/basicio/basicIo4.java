package basicio;

import java.io.*;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午12:30 18-9-30
 * @Modified: null
 */
public class basicIo4 {
    public static void main(String[] args) throws IOException{

        BufferedReader re= new BufferedReader(new InputStreamReader(System.in));
//        String ad = re.readLine();
        char a = 'e';
        int a2 = a;
//        System.out.println(ad);
        while (true) {
            int a1 = re.read();
            System.out.println((char) a1);
//            System.out.println(a2);
        }


    }
}
