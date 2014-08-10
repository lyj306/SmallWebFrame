package com.swf.black.data.sql;

public class SqlFieldTypeUtil {

	
	
	
	
	
	
	
	
	
	
	public static String javaFieldType2SqlFieldType(String javaType, int typeLen) {
		if(javaType == null || javaType.isEmpty())
			return "";
		if("byte".equals(javaType)) {
			return "tinyint(4)";
		} else if("short".equals(javaType)) {
			return "smallint(6)";
		} else if("int".equals(javaType)) {
			return "int(11)";
		} else if("long".equals(javaType)) {
			return "bigint(20)";
		} else if("float".equals(javaType)) {
			return "float";
		} else if("double".equals(javaType)) {
			return "double";
		} else if("text".equals(javaType)) {
			return "text";
		} else if("blob".equals(javaType)) {
			return "blob";
		} else if("String".equals(javaType)) {
			if(typeLen <= 0)
				typeLen = 100;
			if(typeLen >= 50000)
				typeLen = 5000;
			return "varchar("+typeLen+")";
		}
		return javaType;
	}
	
	
}
