package swap;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午10:09 18-9-26
 * @Modified: null
 */
public class Swap5 {
    public static void main(String[] args) {
        int a = -4;
        int b = 2;

        swap(a,b);
        System.out.println(a);
        System.out.println(b);
    }

    public static int swap(int a, int b){
        if(a == b)
            return a;

        if(a > 0 && b > 0 || a < 0 && b < 0){
            a = a - b;
            b = b + a;
            a = b - a;
        }else {
            a = a + b;
            b = a - b;
            a = a - b;
        }

        System.out.println(a);
        System.out.println(b);
        return a;
    }
}
