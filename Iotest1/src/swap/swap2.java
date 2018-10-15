package swap;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:36 18-9-26
 * @Modified: null
 */
public class swap2 {
    public static void main(String[] args) {
        int a = 10;
        int b = 11;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);


    }
}
