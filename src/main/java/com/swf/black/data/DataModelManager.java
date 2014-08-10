package com.swf.black.data;

import java.util.List;

import com.swf.black.data.model.DataConf2ModelUtil;
import com.swf.black.data.sql.DataConf2SqlUtil;
import com.swf.black.data.temp.XmlDataConf;
import com.swf.black.data.xml.Xml2DataConfUtil;


/**
 * 
 * @author luruirui
 *
 */
public class DataModelManager {

	
	
	
	public static void createSqlFromXml(String xmlPath) {
		List<XmlDataConf> xdList = Xml2DataConfUtil.read(xmlPath);
		if(xdList == null || xmlPath.isEmpty()) {
			return;
		}
		for (XmlDataConf xdc : xdList) {
			if(xdc == null)
				continue;
			DataConf2SqlUtil.createSqlFile(xdc);
			DataConf2ModelUtil.createModelFile(xdc);
		}
	}
	
	
	
	public static void main(String[] args) {
		createSqlFromXml("F:\\workspace1.4\\SmallWebFrame\\src\\main\\resource\\data\\tabale\\");
	}
	
	
	
	
}
