package zhujie;

import java.lang.annotation.*;

/**
 * @Author: qiuyunduo
 * @Description: null
 * @Date: Created in 上午12:08 18-9-27
 * @Modified: null
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Person {
    String status() default "活着";
    String sex() default "男";
}