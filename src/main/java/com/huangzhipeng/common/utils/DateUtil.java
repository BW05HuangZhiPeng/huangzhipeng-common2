/**
 * 
 * @Title:         DateUtil.java
 * @Package        com.huangzhipeng.common.utils
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 上午8:12:51
 * @version:       V1.0
 */
package com.huangzhipeng.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**   
 * @ClassName:     DateUtil   
 * 
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 上午8:12:51     
 */
public class DateUtil {
	
	@SuppressWarnings("deprecation")
	public static Date getDateByInitMonth(Date date) throws ParseException {
		//格式
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//将date转成字符
		String format = simpleDateFormat.format(date);
		//截取
		
		String substring = format.substring(0,8);
		//拼接
		substring=substring+"01 00:00:00";
		 Date parse =simpleDateFormat.parse(substring); 
		 
		return parse;
		
	}
	
	public static Date getDateByFullMonth(Date src){
		return src;
		//TODO 实现代码
		}

	public static void main(String[] args) throws ParseException {
		DateUtil.getDateByInitMonth(new Date());
		
		
	}

	
}
