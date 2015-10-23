package by.java.training.chp;

import java.lang.annotation.*;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface NameAnno {

	String value() default "name";

}
