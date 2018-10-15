package swap;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午9:32 18-9-26
 * @Modified: null
 */
public class Swap1 {
    public static void main(String[] args) {
        int a = 9;
        int b = 19;

        a =  b - a;
        b = b - a;
        a = b + a;
        System.out.println(a);
        System.out.println(b);
    }
}
