package zhujie;

import java.lang.annotation.Annotation;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 上午12:09 18-9-27
 * @Modified: null
 */
public class test {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> classtest = Class.forName("zhujie.xiaoming");
//        Annotation[] anns = classtest.getAnnotations();
//
//        for (Annotation annotation : anns){
//            User u = (User)annotation;
//            System.out.println(u.name());
//        }

        Annotation annotation = classtest.getAnnotation(User.class);
        System.out.println(((User)annotation).name());

        annotation = classtest.getAnnotation(Person.class);
        System.out.println(((Person)annotation).sex());
        System.out.println(((Person)annotation).status());
    }
}
