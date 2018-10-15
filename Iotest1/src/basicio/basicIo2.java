package basicio;

import java.io.File;
import java.util.LinkedList;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午6:25 18-6-17
 * @Modified: 递归实现输入任意目录，列出文件以及文件夹
 */
public class basicIo2 {
    public static void main(String[] args) {
        String dirpath = "./";
        File dir = new File(dirpath);

        ListFiles(dir);

        /*LinkedList<File> dirs = new LinkedList<File>();

        dirs.add(dir);

        while(!dirs.isEmpty()){
            File dir1 = dirs.pop();
            System.out.println("文件夹"+dir1.getName()+"中的文件");
            File[] files = dir1.listFiles();

            for (File file : files ) {
                if(file.isFile()){
                    System.out.println("文件："+file.getName());
                }else if(file.isDirectory()) {
                    System.out.println("文件夹："+file.getName());
                    dirs.add(file);
                }else {
                    System.out.println("未知文件");
                }
            }

            System.out.println();
        }*/

    }

    public static void ListFiles(File dir){
        File[] files = dir.listFiles();

        for (File file : files ) {
            if(file.isFile()){
                System.out.println("文件夹："+dir.getName()+"中的文件："+file.getName());
            }else if(file.isDirectory()) {
                ListFiles(file);
            }else {
                System.out.println("未知文件");
            }
        }

        System.out.println();
    }
}
