package BasicType;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 上午10:15 18-10-11
 * @Modified: null
 */
public class booleanAndBoolean {
    public static void main(String[] args) {
        boolean[] bs = new boolean[45];
        boolean bs1 = bs[1];
        System.out.println(bs1);

        Boolean[] bs2 = new Boolean[3];
        Boolean bs3 = bs2[1];
        System.out.println(bs3);

        Boolean bs5 = new Boolean("TRUE");
        System.out.println(bs5);

        boolean bs6 = new Boolean("sd-");
        System.out.println(bs6);

    }
}
