package com.github.ltsopensource.spring.tasktracker;

import java.lang.annotation.*;

/**
 * @author Robert HG (254963746@qq.com)on 12/21/15.
 */
/**
 * for shared task
 * @author Dorae
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface JobRunnerItem {

    String shardValue() default "";
}
