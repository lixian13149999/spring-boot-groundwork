package com.bcdbook.common.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
     * @Title: DateUtil.java    
     * @Description: 时间的工具类
     * @author lason       
     * @created 2017年1月13日 下午6:13:57
 */
public class DateUtil {
	
	/**
	 *
	    * @Discription 获取系统时间戳的方法
	    * 直接返回系统当前时间的时间戳
	    * @author lason
	    * @created 2017年1月13日 下午6:27:12
	    * @return long
	 */
	public static long getTime(){
		//直接返回当前系统时间毫秒数
		return (new Date()).getTime();
	}
	
	/**
	 * 
	    * @Discription 获取不定长时间戳的方法
	    * 获取long类型的,不定长(精度不一定为毫秒)时间戳
	    * @author lason       
	    * @created 2017年1月13日 下午7:22:14     
	    * @param size
	    * @return inset size dataTime
	 */
	public static long getTime(int size){
		/*
		 * 对size的合法性进行验证
		 * 长度太小没有意义
		 * 长度太大会出现错误
		 */
		size = size<0||size>13 ? 13 : size;
		
		//获取指定长度的时间戳字符串
		String dateTimeStr = getTimeStr(size);
		//返回对应长度的时间戳(long类型)
		return Long.parseLong(dateTimeStr);
	}
	
	/**
	 * 
	    * @Discription 获取不定长时间戳的方法
	    * 长度不得超过10(精度为秒)
	    * @author lason       
	    * @created 2017年1月13日 下午7:16:14     
	    * @param size
	    * @return
	 */
	public static int getTimeInt(int size){
		/*
		 * 对size的长度的合法性进行验证
		 * 长度不得超过10,若长度超过10,使用int就有风险,而且对毫秒精度的意义不大
		 */
		size = size<0||size>10 ? 10 : size;
		
		//获取指定长度的时间戳字符串
		String dateTimeStr = getTimeStr(size);
		//返回对应长度的时间戳(int类型)
		return Integer.parseInt(dateTimeStr);
	}
	
	/**
	 * 
	    * @Discription 获取长度为10的int类型的系统时间戳
	    * @author lason       
	    * @created 2017年1月13日 下午7:29:04     
	    * @return
	 */
	public static int getTimeInt10(){
		//调用获取不定长时间戳的方法,并传入特定的值
		return getTimeInt(10);
	}
	
	/**
	 * 
	    * @Discription 获取系统时间戳的方法
	    * 根据传入的size返回相应长度的系统时间戳字符串
	    * 时间戳中多出的部分截取掉
	    * @author lason       
	    * @created 2017年1月13日 下午6:29:24     
	    * @param size
	    * @return
	 */
	public static String getTimeStr(int size){
		/*
		 * 对传入的size进行处理,
		 * 防止传入的size是不合法的
		 * 因为时间戳最长是13位,为防止出现下标越界的问题,截取的长度不能超过13位
		 */
		size = size<0||size>13 ? 13 : size;
		
		//获取系统时间戳并转成字符串类型
		String dateTimeStr = String.valueOf(getTime());
		//返回按照要求截取后的时间戳字符串
		return dateTimeStr.substring(0, size);
	}
	
	/**
	 * 
	    * @Discription 获取系统时间戳的方法
	    * 返回系统时间戳的字符串
	    * @author lason       
	    * @created 2017年1月13日 下午6:28:22     
	    * @return
	 */
	public static String getTimeStr10(){
		/*
		 * 调用获取不定长时间戳字符串的方法,
		 * 并返回默认长度(10位)的时间戳字符串
		 */
		return getTimeStr(10);
	}
	
	/**
	 * 
	    * @Discription 根据传入的时间字符串,想要获取的时间戳的长度,日期格式
	    * 获取对应格式,相应长度的时间戳
	    * @author lason       
	    * @created 2017年1月13日 下午7:33:14     
	    * @param dateTimeSourceStr
	    * @param size
	    * @param pattern
	    * @return
	 */
	public static long getTimeStamp(String dateTimeSourceStr,int size,String pattern){
		/*
		 * 验证参数的合法性
		 * 1. 传入的时间字符串不能为0
		 * 2. 获取的长度不能小于0
		 * 3. 获取的长度不能大于13
		 * 4. 时间字符串的格式不能为空
		 */
		if(StringUtils.isBlank(dateTimeSourceStr)
				|| size<0 
				|| size>13 
				||StringUtils.isBlank(pattern)){
			//如果参数出现错误,直接返回0
			return 0;
		}
		//创建format对象,以格式化传入的时间字符串
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		
		try {
			//根据传入的时间字符串,根据格式,转成时间对象
			Date date = sf.parse(dateTimeSourceStr);
			//根据时间对象获取对应时间的时间戳
			long dateTimeSource = date.getTime();
			//根据需要的长度,截取时间戳字符串
			String dateTimeStr = String.valueOf(dateTimeSource).substring(0, size);
			//返回截取后(转成long类型)的时间戳
			return Long.parseLong(dateTimeStr);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//如果格式化处理或处理过程出现错误,最终返回无效数据0
		return 0;
	}
	
	/**
	 * 
	    * @Discription 根据传入的默认格式的时间字符串获取对应的时间戳
	    * 默认格式为"yyyy-MM-dd HH:mm:ss SSSS"
	    * 返回长度为13
	    * @author lason       
	    * @created 2017年1月13日 下午8:23:45     
	    * @param dateTimeSourceStr
	    * @return
	 */
	public static long getTimeStampDefault(String dateTimeSourceStr){
		//定义时间戳的长度
		int size = 13;
		//定义默认的时间格式
		String pattern = "yyyy-MM-dd HH:mm:ss SSSS";
		return getTimeStamp(dateTimeSourceStr, size, pattern);
	}
	
	/**
	 * 
	    * @Discription 根据传入的时间字符串,要获取的时间戳的长度(小于10),时间字符串的样式
	    * 返回相应的int类型的时间戳
	    * @author lason       
	    * @created 2017年1月13日 下午8:03:58     
	    * @param dateTimeSourceStr
	    * @param size
	    * @param pattern
	    * @return
	 */
	public static int getTimeStampInt(String dateTimeSourceStr,int size,String pattern){
		/*
		 * 验证参数的合法性
		 * 1. 传入的时间字符串不能为0
		 * 2. 获取的长度不能小于0
		 * 3. 获取的长度不能大于10
		 * 4. 时间字符串的格式不能为空
		 */
		if(StringUtils.isBlank(dateTimeSourceStr)
				|| size<0 
				|| size>10 
				||StringUtils.isBlank(pattern)){
			//如果参数出现错误,直接返回0
			return 0;
		}
		//调用根据时间字符串获取时间戳的方法
		String dateTimeStr = String.valueOf(getTimeStamp(dateTimeSourceStr, size, pattern));
		
		return Integer.parseInt(dateTimeStr);
	}
	
	/**
	 * 
	    * @Discription 根据传入的默认格式的时间字符串,获取对应的int类型的时间戳
	    * 默认格式为"yyyy-MM-dd HH:mm:ss"
	    * 返回长度为10
	    * @author lason       
	    * @created 2017年1月13日 下午8:29:56     
	    * @param dateTimeSourceStr
	    * @return
	 */
//	public static int getTimeStampIntDefault(String dateTimeSourceStr){
//		//定义时间戳的长度
//		int size = 10;
//		//定义默认的时间格式
//		String pattern = "yyyy-MM-dd HH:mm:ss";
//		return getTimeStampInt(dateTimeSourceStr, size, pattern);
//	}
	
	/**
	 * 
	    * @Discription 根据传入的默认格式的时间字符串,获取对应的int类型的时间戳
	    * 默认格式为"yyyy-MM-dd"
	    * 返回长度为10
	    * @author lason       
	    * @created 2017年1月13日 下午8:33:21     
	    * @param dateTimeSourceStr
	    * @return
	 */
	public static int getTimeStampIntDefault(String dateTimeSourceStr){
		//定义时间戳的长度
		int size = 10;
		//定义默认的时间格式
		String pattern = "yyyy-MM-dd";
		return getTimeStampInt(dateTimeSourceStr, size, pattern);
	}
	
	/**
	 * 
	    * @Discription 根据传入的int类型的时间戳,输出的格式
	    * 获取对应格式的时间字符串
	    * @author lason       
	    * @created 2017年1月13日 下午8:38:13     
	    * @param timeStamp
	    * @param pattern
	    * @return
	 */
	public static String getDate(int timeStamp,String pattern){
		/*
		 * 验证时间参数的合法性
		 * 1. 传入的时间值不能小于0
		 * 2. 传入的格式不能为空
		 */
		if(timeStamp<0
				||StringUtils.isBlank(pattern)){
			return null;
		}
		
		//把传入的int类型的时间戳转成字符串
		String dateTimeStr = String.valueOf(timeStamp);
		/*
		 * 参数合法性验证
		 * 1. 时间戳字符串不能为空
		 * 2. 输出格式不能为空
		 * 3. 时间戳字符串的长度不能小于10
		 */
		if(StringUtils.isBlank(dateTimeStr)
				||dateTimeStr.length()!=10){
			return null;
		}else{
			//补全时间戳,变成13位
			dateTimeStr+="000";
		}
		
		//把13位的时间戳字符串转成long类型
		long dateTime = Long.parseLong(dateTimeStr);
		//根据转好的时间戳,获取相应的时间对象
		Date date = new Date(dateTime);
		//创建format对象,以格式化传入的时间字符串
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		//生成对应格式的时间字符串
		String backDate = sf.format(date);
		
		return backDate;
	}
	
	/**
	 * 
	    * @Discription 根据传入的int类型的时间戳,输出的格式
	    * 获取默认格式的时间字符串
	    * 默认格式为"yyyy-MM-dd"
	    * @author lason       
	    * @created 2017年1月13日 下午8:38:13     
	    * @param timeStamp
	    * @param timeStamp
	    * @return
	 */
	public static String getDateDefault(int timeStamp){
		return getDate(timeStamp, "yyyy-MM-dd");
	}
	
	/**
	 * 获取当前时间指定几个月前的日期
	 * 例:获取三个月前的日期时间戳 传入-3
	 * @param monthNum
	 * @return
	 */
	public static int getAssignMonthTimeStamp(int monthNum){
		Date dNow = new Date();   //当前时间
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(dNow);//把当前时间赋给日历
		calendar.add(calendar.MONTH, monthNum);  //设置为前3月
		dBefore = calendar.getTime();   //得到前3月的时间
		String str = String.valueOf(dBefore.getTime());
		str = str.substring(0, 10);
		return Integer.valueOf(str);
	}
	
	
	
	/**
	 * 根据时间计算开始
	 * @param type
	 * @return
	 */
	public static int getDateStart(int type){
		
		switch(type){
			case 1 : {//当前天数的开始
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
				SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				Date d =new Date();
				String str = format.format(d);
				str += " 00:00:00";
				
				//获取时间字符串
				String dateTimeStr = "0";
				try {
					dateTimeStr = String.valueOf(format2.parse(str).getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//返回对应长度的时间戳(int类型)
				return Integer.parseInt(dateTimeStr.substring(0,10));
				
			}
			case 2 :{//当周的开始的开始时间
				   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
				   SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				   Calendar cal = Calendar.getInstance();

//					cal.setTime(new SimpleDateFormat("yyyy-MM-dd"));

					int d = 0;
					if(cal.get(Calendar.DAY_OF_WEEK)==1){
						d = -6;
					}else{
						d = 2-cal.get(Calendar.DAY_OF_WEEK);
					}
					cal.add(Calendar.DAY_OF_WEEK, d);
					//所在周开始日期
					String str =new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
			        str += " 00:00:00";
			        //获取时间字符串
					String dateTimeStr = "0";
					try {
						dateTimeStr = String.valueOf(format2.parse(str).getTime());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//返回对应长度的时间戳(int类型)
					return Integer.parseInt(dateTimeStr.substring(0,10));
					
			}
			case 3 :{//当月的开始
				   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
				   SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			        
			        //获取前月的第一天
			        Calendar   cal_1=Calendar.getInstance();//获取当前日期 
			        cal_1.add(Calendar.MONTH, -1);
			        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
			        String str = format.format(cal_1.getTime());
			        str += " 00:00:00";
			        //获取时间字符串
					String dateTimeStr = "0";
					try {
						dateTimeStr = String.valueOf(format2.parse(str).getTime());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//返回对应长度的时间戳(int类型)
					return Integer.parseInt(dateTimeStr.substring(0,10));
					
			}
		}
		return 0;
	}
	/**
	 * 根据类型计算结束时间
	 * @param type
	 * @return
	 */
	public static int getDateEnd(int type){
		
		switch(type){
			case 1 : {//当前天数的结束
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
				SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				Date d =new Date();
				String str = format.format(d);
				str += " 23:59:59";
				
				//获取时间字符串
				String dateTimeStr = "0";
				try {
					dateTimeStr = String.valueOf(format2.parse(str).getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//返回对应长度的时间戳(int类型)
				return Integer.parseInt(dateTimeStr.substring(0,10));
				
			}
			case 2 :{//当周的开始的结束时间
				   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
				   SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				   Calendar cal = Calendar.getInstance();

//					cal.setTime(new SimpleDateFormat("yyyy-MM-dd"));

					int d = 0;
					if(cal.get(Calendar.DAY_OF_WEEK)==1){
						d = -6;
					}else{
						d = 2-cal.get(Calendar.DAY_OF_WEEK);
					}
					cal.add(Calendar.DAY_OF_WEEK, d);
					cal.add(Calendar.DAY_OF_WEEK, 6);
					//所在周结束日期
					String str =new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
			        str += " 23:59:59";
			        //获取时间字符串
					String dateTimeStr = "0";
					try {
						dateTimeStr = String.valueOf(format2.parse(str).getTime());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//返回对应长度的时间戳(int类型)
					return Integer.parseInt(dateTimeStr.substring(0,10));
					
			}
			case 3 :{//当月的结束
				   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
				   SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			        //获取前月的第一天
			        Calendar   cal_1=Calendar.getInstance();//获取当前日期 
			        cal_1.set(Calendar.DAY_OF_MONTH, cal_1.getActualMaximum(Calendar.DAY_OF_MONTH));  
			        String str = format.format(cal_1.getTime());
			        str += " 23:59:59";
			        //获取时间字符串
					String dateTimeStr = "0";
					try {
						dateTimeStr = String.valueOf(format2.parse(str).getTime());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//返回对应长度的时间戳(int类型)
					return Integer.parseInt(dateTimeStr.substring(0,10));
					
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(getTimeStr10());
		System.out.println(getAssignMonthTimeStamp(-1));
//		cal.setTime(new SimpleDateFormat("yyyy-MM-dd"));

		int d = 0;
		if(cal.get(Calendar.DAY_OF_WEEK)==1){
			d = -6;
		}else{
			d = 2-cal.get(Calendar.DAY_OF_WEEK);
		}
		cal.add(Calendar.DAY_OF_WEEK, d);
		//所在周开始日期
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
		cal.add(Calendar.DAY_OF_WEEK, 6);
		//所在周结束日期
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));

	}

}
