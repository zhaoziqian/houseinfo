package com.zhaoziqian.houseinfo.util;

public class EmptyString {

	/**
	 * 
	* @Title: isEmpty 
	* @Description: 判断字符串是否为空 
	* @param @param str
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean isEmpty(String str){
		if (str == null || str.trim().length() == 0) {
			return true;
		}
		return false;
	}
}
