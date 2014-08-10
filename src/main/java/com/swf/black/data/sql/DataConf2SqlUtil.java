package com.swf.black.data.sql;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.swf.black.data.temp.XmlDataConf;
import com.swf.black.data.temp.XmlDbFieldConf;
import com.swf.black.data.temp.XmlDbconf;
import com.swf.conf.Common;

public class DataConf2SqlUtil {

	
	public static String sqlFilePath = "data\\tabale\\";
	
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
		buff.append("\n) ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		
		String path = Common.getSrcMainResource()+sqlFilePath+dbConf.getTable()+".sql";
		File file = new File(path);
		try {
			FileUtils.writeStringToFile(file, buff.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
