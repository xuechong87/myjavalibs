package com.xuechong.utils.json;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author xuechong
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)  
@Documented 
public @interface JSON {
	String name ();
	Class<? extends JsonTransformer> transFormerClass() default DefaultJsonTransfomer.class;
}
