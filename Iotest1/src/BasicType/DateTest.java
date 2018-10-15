package BasicType;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午4:16 18-9-19
 * @Modified: null
 */
public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        Calendar calendar = Calendar.getInstance();
        int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(actualMaximum);
        calendar.add(Calendar.DATE,-1);
        System.out.println(calendar.getTime());
        char ch = '邱';
        char ch1 = '运';
        char ch2 = '铎';
        byte bt = (byte)ch;
        byte bt1 = (byte)ch1;
        byte bt2 = (byte)ch2;
        System.out.println(ch);
        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(bt);
        System.out.println(bt1);
        System.out.println(bt2);

        byte name = -79;
        char name1 = (char)name;
        System.out.println(name1);
    }
}
