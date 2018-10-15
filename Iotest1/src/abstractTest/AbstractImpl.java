package abstractTest;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 下午3:31 18-9-19
 * @Modified: null
 */
public class AbstractImpl extends AbstractClass implements MyInterace2 {
    private AbstractImpl() {
        super();
    }

    @Override
    public void test() {
        System.out.println("test");
    }

    @Override
    public void test3() {
        System.out.println("test3");
    }

    @Override
    public void mytest() {
        System.out.println("mytest");
    }

    public static void main(String[] args) {
        AbstractClass abstractE = new AbstractImpl();
        abstractE.test();
        abstractE.test1();
        AbstractImpl abstracatA = new AbstractImpl();
        abstracatA.mytest();
        abstracatA.test3();
    }
}
