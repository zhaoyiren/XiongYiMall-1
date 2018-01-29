package com.xiongyi.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author GUXIONG
 * @description ���ڴ���
 */
public class DateUtil {
	
	private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
	private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
	private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");
	private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * ��ȡYYYY��ʽ
	 * @return
	 */
	public static String getYear() {
		return sdfYear.format(new Date());
	}

	/**
	 * ��ȡYYYY-MM-DD��ʽ
	 * @return
	 */
	public static String getDay() {
		return sdfDay.format(new Date());
	}
	
	/**
	 * ��ȡYYYYMMDD��ʽ
	 * @return
	 */
	public static String getDays(){
		return sdfDays.format(new Date());
	}

	/**
	 * ��ȡYYYY-MM-DD HH:mm:ss��ʽ
	 * @return
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}

	/**
	* @Title: compareDate
	* @Description: TODO(���ڱȽϣ����s>=e ����true ���򷵻�false)
	* @param s
	* @param e
	* @return boolean  
	* @throws
	* @author fh
	 */
	public static boolean compareDate(String s, String e) {
		if(fomatDate(s)==null||fomatDate(e)==null){
			return false;
		}
		return fomatDate(s).getTime() >=fomatDate(e).getTime();
	}

	/**
	 * ��ʽ������
	 * @return
	 */
	public static Date fomatDate(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * У�������Ƿ�Ϸ�
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// ���throw java.text.ParseException����NullPointerException����˵����ʽ����
			return false;
		}
	}
	
	/**
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static int getDiffYear(String startTime,String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//long aa=0;
			int years=(int) (((fmt.parse(endTime).getTime()-fmt.parse(startTime).getTime())/ (1000 * 60 * 60 * 24))/365);
			return years;
		} catch (Exception e) {
			// ���throw java.text.ParseException����NullPointerException����˵����ʽ����
			return 0;
		}
	}
	 
	/**
     * <li>����������ʱ������õ�����
     * @param beginDateStr
     * @param endDateStr
     * @return
     * long 
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr,String endDateStr){
        long day=0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date beginDate = null;
        java.util.Date endDate = null;
        
            try {
				beginDate = format.parse(beginDateStr);
				endDate= format.parse(endDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
            //System.out.println("���������="+day);
      
        return day;
    }
    
    /**
     * �õ�n��֮�������
     * @param days
     * @return
     */
    public static String getAfterDayDate(String days) {
    	int daysInt = Integer.parseInt(days);
    	
        Calendar canlendar = Calendar.getInstance(); // java.util��
        canlendar.add(Calendar.DATE, daysInt); // ���ڼ� ����������Ὣ�±䶯
        Date date = canlendar.getTime();
        
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);
        
        return dateStr;
    }
    
    /**
     * �õ�n��֮�����ܼ�
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
    	int daysInt = Integer.parseInt(days);
        Calendar canlendar = Calendar.getInstance(); // java.util��
        canlendar.add(Calendar.DATE, daysInt); // ���ڼ� ����������Ὣ�±䶯
        Date date = canlendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);
        return dateStr;
    }
    
    public static void main(String[] args) {
    	System.out.println(getDays());
    	System.out.println(getAfterDayWeek("3"));
    }

}
