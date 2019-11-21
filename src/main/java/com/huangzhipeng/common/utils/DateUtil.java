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
import java.util.Calendar;
import java.util.Date;

/**   
 * @ClassName:     DateUtil   
 * 
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019��11��21�� ����8:12:51     
 */
public class DateUtil {
	
	/**
	 * ��ȡָ�����������·ݿ�ʼ��ʱ��
	 * lkeji
	 * @return
	 */
	    public static String getDateByInitMonth(String specifiedDay) {
	        Date data = null;
	        try {
	            data = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        Calendar c = Calendar.getInstance();
	        c.setTime(data);
	        //����Ϊ1��,��ǰ���ڼ�Ϊ���µ�һ��
	        c.set(Calendar.DAY_OF_MONTH, 1);
	        //��Сʱ��0
	        c.set(Calendar.HOUR_OF_DAY, 0);
	        //��������0
	        c.set(Calendar.MINUTE, 0);
	        //������0
	        c.set(Calendar.SECOND,0);
	        //��������0
	        c.set(Calendar.MILLISECOND, 0);
	        // ���µ�һ���ʱ���ת��Ϊ�ַ���
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date date;
	        try {
	            date = sdf.parse(sdf.format(new Date(new Long(c.getTimeInMillis()))));
	            //Date date = sdf.parse(sdf.format(new Long(s)));// �ȼ���
	            return sdf.format(date);
	        } catch (NumberFormatException e) {
	            // TODO �Զ����ɵ� catch ��
	            e.printStackTrace();
	        } catch (ParseException e) {
	            // TODO �Զ����ɵ� catch ��
	            e.printStackTrace();
	        }
	        return null;
	    }


	  /**
	     * ��ȡָ�����������·ݽ�����ʱ��
	     * @return
	     */
	    public static String getDateByFullMonth(String specifiedDay) {
	        Date data = null;
	        try {
	            data = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        Calendar c = Calendar.getInstance();
	        c.setTime(data);

	        //����Ϊ�������һ��
	        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
	        //��Сʱ��23
	        c.set(Calendar.HOUR_OF_DAY, 23);
	        //��������59
	        c.set(Calendar.MINUTE, 59);
	        //������59
	        c.set(Calendar.SECOND, 59);
	        //��������999
	        c.set(Calendar.MILLISECOND, 999);
	        // ���µ�һ���ʱ���ת��Ϊ�ַ���
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date date;
	        try {
	            date = sdf.parse(sdf.format(new Date(new Long(c.getTimeInMillis()))));
	            //Date date = sdf.parse(sdf.format(new Long(s)));// �ȼ���
	            return sdf.format(date);
	        } catch (NumberFormatException e) {
	            // TODO �Զ����ɵ� catch ��
	            e.printStackTrace();
	        } catch (ParseException e) {
	            // TODO �Զ����ɵ� catch ��
	            e.printStackTrace();
	        }
	        return null;
	    }

	
}
