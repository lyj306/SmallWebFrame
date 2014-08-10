package com.swf.black.data.sql;

import com.swf.black.data.temp.XmlDataConf;
import com.swf.black.data.temp.XmlDbFieldConf;
import com.swf.black.data.temp.XmlDbconf;

public class DataConf2SqlUtil {

	
	public static String sqlFilePath = "D:/";
	
	public static void createSqlFile(XmlDataConf xdc) {
		if(xdc == null || xdc.getDbConf() == null)
			return;
		buildSqlFromDataConf(xdc.getDbConf());
	}
	
	
	
	private static void buildSqlFromDataConf(XmlDbconf dbConf) {
		StringBuilder buff = new StringBuilder();
		buff.append("\nDROP TABLE IF EXISTS `").append(dbConf.getTable()).append("`;")
			.append("\nCREATE TABLE `").append(dbConf.getTable()).append("` (");
		
		if(dbConf.getFields() != null) {
			for (XmlDbFieldConf fieldConf : dbConf.getFields()) {
				if(fieldConf == null)
					continue;
				buff.append("\n\t").append(fieldConf.toSql()).append(",");
			}
			buff.append("\n\tPRIMARY KEY (`").append(dbConf.getKey()).append("`)");
		}
		buff.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		
		String sql = buff.toString();
		
	}
	
}
