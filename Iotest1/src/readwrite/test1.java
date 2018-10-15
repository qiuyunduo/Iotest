package readwrite;

import java.io.*;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午7:08 18-6-17
 * @Modified: null
 */
public class test1 {
    public static void main(String[] args) throws IOException {
        File file = new File("Iotest1/IOTest/readwrite.txt");

        if(!file.exists()){
            file.createNewFile();
        }

//        FileReader Fr = new FileReader(file);
//        FileWriter FW = new FileWriter(file);
//
//        FW.write("从前有座灵剑山");
//        FW.close();
//        char[] ch = new char[100];
//        int len = 0;
//        while((len = Fr.read(ch)) != -1){
//            String str = new String(ch,0,len);
//            //String str = String.valueOf(ch);
//            System.out.println(str);
//        }
//        FW.close();

//        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//        BufferedReader br = new BufferedReader(new FileReader(file));
//
//        bw.write("从前有座灵剑山,以北京月光,一别经赵亚光");
//        bw.close();
//        System.out.println(br.readLine());
//        br.close();

//        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
//
//        while(true){
//            String str = br1.readLine();
//            if(str.equals("quit"))
//                break;
//            System.out.println(str);
//        }

        InputStreamReader is = new InputStreamReader(new FileInputStream(file));
        OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(file));

        os.write("从前有座灵剑山,已经不是从前的灵剑山");
        os.close();
        char[] ch = new char[100];
        int len = 0;
        while((len = is.read(ch)) != -1){
            String str = new String(ch,0,len);
            //String str = String.valueOf(ch);
            System.out.println(str);
        }
        is.close();


    }
}
