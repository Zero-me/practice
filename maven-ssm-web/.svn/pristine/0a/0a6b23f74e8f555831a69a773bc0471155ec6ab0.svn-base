package com.zero.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.zero.common.MethodResult;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *	参数校验预处理
 * @author Zero-me
 *
 */
public class ParamCheck {
	/**
	 * 输出日志
	 */
	private Logger log = Logger.getLogger(ParamCheck.class);

	
	/**
	 * 校验从前端送来的参数，不接收不需要的参数
	 * @param contextReq  请求容器
	 * @param paramList		参数列表
	 * @return
	 */
	public static HashMap<String,Object>  paramLimit(HashMap<String,Object> contextReq,ArrayList<String> paramList) {
		
		HashMap<String,Object> resDict = new HashMap<String, Object>();
		
		for(String item:contextReq.keySet()) {
			if(paramList.contains(item)) {
				Object value = contextReq.get(item).toString();
				if(value instanceof String) {
					if(value != null && !value.equals("")) {
						resDict.put(item, value);
					}
				}else {
					resDict.put(item, value);
				}
			}
		}
		return resDict;
	}
	
	
	public static void main(String[] args) {
		HashMap<String, Object> reqDict = new HashMap<String, Object>();
		reqDict.put("name", "zero");
		reqDict.put("corpoboss", "4343");
		reqDict.put("corpoprice", "");
		
//		Logger logger = Logger.getLogger(ParamCheck.class.toString());
//		logger.log(logger.getLevel().INFO, "1212");
//		MethodResult dd  = getAutoBean("Corporation",reqDict,null);
//		System.out.println(dd);
//		if(dd.getRetcode().equals("S")) {
//			System.out.println("处理成功");
//			System.out.println(dd.getResult());
//		}
	}
	
	
	/**
	 * 根据请求参数和model自动装配Javabean
	 * @param modelName
	 * @param reqDict
	 * @param basePkg
	 * @return
	 */
	public static MethodResult getAutoBean(String modelName,Map<String, Object> reqDict,String basePkg) {
		
		MethodResult result = new MethodResult();
		if(basePkg == null || "".equals(basePkg)) {
			basePkg = "com.zero.model";
		}
		
		Set<String> keyset =  reqDict.keySet();
		for(String item:keyset) {
			if(!checkStrUL(item)) {
				result.setRetcode("ERROR");
				result.setRetmsg("接口请求参数字段[" + item + "]不能含有大写字母");
				return result;
			}
		}
		
		
		try {
			Class<?> clazz = Class.forName(basePkg + "." + modelName);
			Object model = clazz.newInstance();
			Method[] methosd =  clazz.getDeclaredMethods();
			for (Method mm:methosd) {
				String methodName = mm.getName();
				if(methodName.startsWith("set")) {
					String key = methodName.replaceFirst("set", "").toLowerCase();
					if(keyset.contains(key) && reqDict.get(key) != null && !reqDict.get(key).toString().equals("")) {
						try {
							mm.invoke(model, reqDict.get(key));
						} catch (IllegalArgumentException e) {
							result.setRetcode("ERROR");
							result.setRetmsg("处理失败：  参数类型不匹配：[" + key + "] = " + reqDict.get(key));
							return result;
						}
					}
				}
			}
			result.setRetcode("SUCCESS");
			result.setResult(model);
			return result;
		} catch (ClassNotFoundException e) {
			result.setRetcode("ERROR");
			result.setRetmsg("处理失败：  javabean不存在：[" + basePkg + "." + modelName + "]");
			return result;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 判断字符串中是否含有大写字母，接口要求字段必须全是小写字母
	 * @param src
	 * @return
	 */
	public static boolean checkStrUL(String src) {
		
		for(int i=0;i<src.length();i++) {
			char c = src.charAt(i);
			if(Character.isUpperCase(c)) {
				return false;
			}
		}
		return true;
	}
	
}
