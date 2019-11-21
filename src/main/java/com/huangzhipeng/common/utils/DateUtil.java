/**
 * 
 * @Title:         DateUtil.java
 * @Package        com.huangzhipeng.common.utils
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019��11��21�� ����8:12:51
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
 * @date:          2019��11��21�� ����8:12:51     
 */
public class DateUtil {
	
	@SuppressWarnings("deprecation")
	public static Date getDateByInitMonth(Date date) throws ParseException {
		//��ʽ
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//��dateת���ַ�
		String format = simpleDateFormat.format(date);
		//��ȡ
		
		String substring = format.substring(0,8);
		//ƴ��
		substring=substring+"01 00:00:00";
		 Date parse =simpleDateFormat.parse(substring); 
		 
		return parse;
		
	}
	
	public static Date getDateByFullMonth(Date src){
		return src;
		//TODO ʵ�ִ���
		}

	public static void main(String[] args) throws ParseException {
		DateUtil.getDateByInitMonth(new Date());
		
		
	}

	
}
