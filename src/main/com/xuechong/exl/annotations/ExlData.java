package com.xuechong.exl.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 声明为需要导出的数据列
 * 
 *<pre>@ExlModel(viewTypes={0,1,2,3})
 *public class PersonModel {
 *	@ExlData(sortId=1,title={"名字","名字","","名字"})
 *	private String name;
 *	@ExlData(sortId=2,title={"年龄","age","age",""})
 *	private Integer age;
 *	@ExlData(sortId=3,title={"姓","姓","familyName","姓"})
 *	private String familyName;
 *	@ExlData(sortId=4,title={"身份证","证件号","IDCODE","IDCODE"})
 *	private String idCode;
 *}
 *</pre>
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
