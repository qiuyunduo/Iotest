package basicio;

import java.io.*;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午1:46 18-9-30
 * @Modified: null
 */
public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("Iotest1/src/HelloWorld.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(new User("小明",15,true));
        outputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("Iotest1/src/HelloWorld.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        User user = (User) objectInputStream.readObject();
        System.out.println(user);
        objectInputStream.close();
        fileInputStream.close();
    }
}
