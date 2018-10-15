package BasicType;

import java.io.UnsupportedEncodingException;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午4:11 18-9-19
 * @Modified: null
 */
public class StringTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        int a = Integer.valueOf("12");
        System.out.println(a);
        char[] chs = {'s','f','s'};
        String str = String.valueOf(chs);
        System.out.println(str);
        char[] ch1s = str.toCharArray();
        System.out.println(ch1s[0]);

        StringBuilder str1 = new StringBuilder("sd");
        str1.reverse();
        System.out.println(str1);

        String str2 = "sdsdsd学习";
        String str3 = new String(str2.getBytes("GB2312"),"ISO-8859-1");

    }
}
