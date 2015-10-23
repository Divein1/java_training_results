package by.java.training.chp;

import java.lang.annotation.*;

@Target(value=ElementType.METHOD)
@Retention(value=RetentionPolicy.RUNTIME)
@Documented
public @interface MethAnno {
 String name();
}
