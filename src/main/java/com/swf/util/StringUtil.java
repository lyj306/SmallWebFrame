package com.swf.util;

public class StringUtil {

	
	public static final boolean isEmpty(String str) {
		return str == null || str.isEmpty();
	}
	
	
	
	public static final int parseInt(String str) {
		if(isEmpty(str)) {
			return 0;
		}
		try{
			return Integer.parseInt(str);
		} catch(Exception e){}
		return 0;
	}
	
	
	
	
}
