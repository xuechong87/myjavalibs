package com.xuechong.exl.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 声明为需要导出的数据列
 * @author xuechong
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)  
@Documented 
public @interface ExlData {

	/**
	 * 显示时的标题
	 * @return
	 * @author xuechong
	 */
	String[] title();
	
	/**
	 * 显示时的序号
	 * @return
	 * @author xuechong
	 */
	int sortId();

}
