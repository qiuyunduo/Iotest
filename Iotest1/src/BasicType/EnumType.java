package BasicType;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午5:33 18-9-18
 * @Modified: null
 */
public class EnumType {
    public static void main(String[] args) {
        Day day = Day.MONDAY;
        System.out.println(day.getId());
        System.out.println(day.getName());
        String a = "Programming";
        String b = new String("Programming");
        String c = "Program" + "ming";

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.intern() == b.intern());
    }
}


