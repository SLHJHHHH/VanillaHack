package com.vanillahack.api.utils.functions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface FunctionRegister {
    String name();
    Category category();
    String description() default "";
    int bind() default -999;
}
