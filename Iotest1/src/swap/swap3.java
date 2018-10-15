package swap;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:56 18-9-26
 * @Modified: null
 */
public class swap3 {
    public static void main(String[] args) {
        int a = 2;
        int b = 4;

        a ^= b;
        b ^= a;
        a ^= b;


        System.out.println(a);
        System.out.println(b);
    }

}
