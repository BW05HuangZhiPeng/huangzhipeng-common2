/**
 * 
 * @Title:         StreamUtil.java
 * @Package        com.huangzhipeng.common.utils
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 上午8:13:15
 * @version:       V1.0
 */
package com.huangzhipeng.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**   
 * @ClassName:     StreamUtil   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 上午8:13:15     
 */
public class StreamUtil {
	
	
	public static void closeAll(AutoCloseable src) throws IOException {
	try {
	src.close();
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
	/*
	方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(10分)，要求方法内部调用上面第1个方法关闭流(5分)
	*/
	@SuppressWarnings("finally")
	public static String readTextFile(InputStream src) {
		
	BufferedReader reader = new BufferedReader(new InputStreamReader(src, StandardCharsets.UTF_8));
	byte b[] = new byte[2048];
	int len = 0;
	int temp = 0;
	String stu = "";
	try {
	while ((temp = reader.read()) != -1) {
	b[len] = (byte) temp;
	len++;
	}
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} finally {
	try {
	closeAll(src);
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	return new String(b, 0, len);
	}
	}
	/*
	方法3：传入文本文件对象，返回该文件内容(10分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	*/
	@SuppressWarnings({ "resource", "finally" })
	public static String readTextFile(File txtFile) {
	String file = "";
	try {
	FileInputStream inputStream = new FileInputStream(txtFile);
	file = readTextFile(inputStream);
	} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} finally {
	return file;
	}
	}
	//File f 文件目录,rootPath 根目录,outPath输出目录,suffix输出文件的后缀名
	public static void CopyToPath(File f, String rootPath, String outPath, String suffix) {
	File[] files = f.listFiles();
	for (File file : files) {
	//输出流
	OutputStreamWriter writer = null;
	//获取当前文件在目录下的路径
	String path = file.getPath();
	//截取根目录后面的字符串
	String substring = path.substring(rootPath.length());
	//将输出目录和文件路径拼接,生成新的路径
	File file2 = new File(outPath + substring);
	//判断是否文件
	if (!file.isDirectory() && file != null) {
	//获取文件后缀名
	String string = FileUtil.getExtendName(file.getName());
	//判断是否是要输出的文件
	if (string.equals(suffix)) {
	//读取当前文件内容
	String string2 = StreamUtil.readTextFile(file);
	try {
	//获取输出流
	writer = new OutputStreamWriter(new FileOutputStream(file2));
	//将文件内容,输出到指定地址
	writer.write(string2);
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} finally {
	try {
	writer.flush();
	writer.close();
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
	//关闭流
	} else {
	continue;
	}
	} else {
	//判断输出目录是否存在,不存在则创建
	if (!file2.exists()) {
	file2.mkdirs();
	}
	//判断时目录,则递归
	CopyToPath(file, rootPath, outPath, suffix);
	System.out.println("递归中");
	}
	}
	}
	}



