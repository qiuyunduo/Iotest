package swap;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午10:05 18-9-26
 * @Modified: null
 */
public class swap4 {
    public static void main(String[] args) {
        int a = 2;
        int b = 4;

        a = a - b;
        b = b + a;
        a = b - a;

        System.out.println(a);
        System.out.println(b);
    }


}
