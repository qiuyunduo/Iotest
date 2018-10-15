package basicio;

import java.io.File;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午6:53 18-6-17
 * @Modified: null
 */
public class basicIo3 {
    public static void main(String[] args) {
        String dirpath = "./";

        File dir = new File(dirpath);

        ListJavaFiles(dir);


    }

    public static void ListJavaFiles(File dir){
        File[] files = dir.listFiles();

        String filename;

        for (File file : files ) {
            if(file.isFile()){
                filename = file.getName();
                if(filename.matches("(.*)\\.java"))
                    System.out.println("文件夹："+dir.getName()+"中的.java文件："+file.getName());
            }else if(file.isDirectory()) {
                ListJavaFiles(file);
            }else {
                System.out.println("未知文件");
            }
        }
    }
}
