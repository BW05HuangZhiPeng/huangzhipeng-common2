/**
 * 
 * @Title:         FileUtil.java
 * @Package        com.huangzhipeng.common.utils
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 上午8:13:04
 * @version:       V1.0
 */
package com.huangzhipeng.common.utils;

/**   
 * @ClassName:     FileUtil   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 上午8:13:04     
 */
public class FileUtil {

	/*
	* 方法1：给定一个文件名，返回该文件名的扩展名，例如“aaa.jpg”，返回“.jpg”(10分)
	*/
	public static String getExtendName(String fileName){
		String substring = fileName.substring(fileName.lastIndexOf("."));
		return substring;
	
	}

}
