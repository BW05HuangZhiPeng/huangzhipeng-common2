/**
 * 
 * @Title:         StreamUtil.java
 * @Package        com.huangzhipeng.common.utils
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019��11��21�� ����8:13:15
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
 * @date:          2019��11��21�� ����8:13:15     
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
	����2������һ���ı��ļ�����Ĭ��ΪUTF-8���룬���ظ��ļ�����(10��)��Ҫ�󷽷��ڲ����������1�������ر���(5��)
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
	����3�������ı��ļ����󣬷��ظ��ļ�����(10��)������Ҫ���ڲ����������2������(5��)��* ���ǵ��͵ķ������أ���ס�������ꡭ
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
	//File f �ļ�Ŀ¼,rootPath ��Ŀ¼,outPath���Ŀ¼,suffix����ļ��ĺ�׺��
	public static void CopyToPath(File f, String rootPath, String outPath, String suffix) {
	File[] files = f.listFiles();
	for (File file : files) {
	//�����
	OutputStreamWriter writer = null;
	//��ȡ��ǰ�ļ���Ŀ¼�µ�·��
	String path = file.getPath();
	//��ȡ��Ŀ¼������ַ���
	String substring = path.substring(rootPath.length());
	//�����Ŀ¼���ļ�·��ƴ��,�����µ�·��
	File file2 = new File(outPath + substring);
	//�ж��Ƿ��ļ�
	if (!file.isDirectory() && file != null) {
	//��ȡ�ļ���׺��
	String string = FileUtil.getExtendName(file.getName());
	//�ж��Ƿ���Ҫ������ļ�
	if (string.equals(suffix)) {
	//��ȡ��ǰ�ļ�����
	String string2 = StreamUtil.readTextFile(file);
	try {
	//��ȡ�����
	writer = new OutputStreamWriter(new FileOutputStream(file2));
	//���ļ�����,�����ָ����ַ
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
	//�ر���
	} else {
	continue;
	}
	} else {
	//�ж����Ŀ¼�Ƿ����,�������򴴽�
	if (!file2.exists()) {
	file2.mkdirs();
	}
	//�ж�ʱĿ¼,��ݹ�
	CopyToPath(file, rootPath, outPath, suffix);
	System.out.println("�ݹ���");
	}
	}
	}
	}



