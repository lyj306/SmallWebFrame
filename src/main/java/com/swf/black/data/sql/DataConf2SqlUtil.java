package com.swf.black.data.sql;

import com.swf.black.data.temp.XmlDataConf;
import com.swf.black.data.temp.XmlDbFieldConf;
import com.swf.black.data.temp.XmlDbconf;

public class DataConf2SqlUtil {

	
	public static void createSqlFile(XmlDataConf xdc) {
		if(xdc == null || xdc.getDbConf() == null)
			return;
		String sql = buildSqlFromDataConf(xdc.getDbConf());
	}
	
	
	
	private static String buildSqlFromDataConf(XmlDbconf dbConf) {
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
		
		return buff.toString();
	}
	
}
