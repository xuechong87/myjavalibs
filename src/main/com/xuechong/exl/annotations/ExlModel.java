package com.xuechong.exl.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 声明为可用于导出EXL的模型
 * @author xuechong
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)  
@Documented 
public @interface ExlModel {
	
	/**
	 * 
	 * @return
	 * @author xuechong
	 */
	int[] viewTypes() default {0}; 
}
