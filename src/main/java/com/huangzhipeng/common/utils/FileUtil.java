/**
 * 
 * @Title:         FileUtil.java
 * @Package        com.huangzhipeng.common.utils
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019��11��21�� ����8:13:04
 * @version:       V1.0
 */
package com.huangzhipeng.common.utils;

/**   
 * @ClassName:     FileUtil   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019��11��21�� ����8:13:04     
 */
public class FileUtil {

	/*
	* ����1������һ���ļ��������ظ��ļ�������չ�������硰aaa.jpg�������ء�.jpg��(10��)
	*/
	public static String getExtendName(String fileName){
		String substring = fileName.substring(fileName.lastIndexOf("."));
		return substring;
	
	}

}
