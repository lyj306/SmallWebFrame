package com.swf.black.data.temp;

public class XmlDataConf {

	XmlDbconf dbConf = null;

	public XmlDbconf getDbConf() {
		return dbConf;
	}
	
	public XmlDbconf initDbConf() {
		if(dbConf == null)
			dbConf = new XmlDbconf();
		return dbConf;
	}

	public void setDbConf(XmlDbconf dbConf) {
		this.dbConf = dbConf;
	}
	
	
}
