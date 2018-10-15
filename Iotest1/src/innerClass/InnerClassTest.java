package innerClass;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午3:50 18-9-19
 * @Modified: null
 */
public class InnerClassTest {
    private int number = 10;

    public void test(){
        System.out.println("我访问发到了吗？");
    }

    class son{
        private int number1 = 11;

        public void test1(){
            test();
            System.out.println("访问到了内部类外部类的私有元素number:"+number);
        }
    }

    public static void main(String[] args) {
        InnerClassTest innerClassTest = new InnerClassTest();
        InnerClassTest.son son = innerClassTest.new son();
        son.test1();



    }
}
