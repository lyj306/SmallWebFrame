package com.swf.black.data.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.swf.black.data.temp.XmlDataConf;


public class Xml2DataConfUtil {

	static SAXReader saxReader = new SAXReader();
	
	
	public static List<XmlDataConf> read(String xmlConfPath) {
		File xmlFile = new File(xmlConfPath);
		if(!xmlFile.exists()) {
			return null;
		}
		List<XmlDataConf> list = new ArrayList<XmlDataConf>();
		 read(list, xmlFile);
		 return list;
	}
	
	public static void read(List<XmlDataConf> list, File xmlFile) {
		if(xmlFile.isDirectory()) {
			File[] arr = xmlFile.listFiles();
			if(arr != null && arr.length > 0) {
				for(File f : arr) {
					read(list, f);
				}
			}
		} else {
			XmlDataConf xd = coverXmlToObject(xmlFile);
			if(xd != null)
				list.add(xd);
		}
		return;
	}
	
	private static XmlDataConf coverXmlToObject(File f) {
		try {
			Document doc = saxReader.read(f);
			Element e = doc.getRootElement();
			Element dbconf = e.element("dbconf");
			if(dbconf != null) {
				return coverElementToObject(dbconf);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private static XmlDataConf coverElementToObject(Element dbConfElement) {
		XmlDataConf xd = new XmlDataConf();
		xd.initDbConf();
		xd.getDbConf().setTable(getSubElementValue(dbConfElement, "table"));
		xd.getDbConf().setKey(getSubElementValue(dbConfElement, "key"));
		
		List<Element> fieldList = null;
		Element fieldsNode = dbConfElement.element("fields");
		if(fieldsNode != null) {
			fieldList = fieldsNode.elements();
		}
		if(fieldList != null && !fieldList.isEmpty()) {
			xd.getDbConf().initFiledSize(fieldList.size());
			for (int i=0; i<fieldList.size(); i++) {
				Element e = fieldList.get(i);
				String fieldName = e.getName();
				String type = getAttributeValue(e, "type");
				String typeLength = getAttributeValue(e, "len");
				String comments = getAttributeValue(e, "comments");
				String defValue = getAttributeValue(e, "default");
				String scopeSelect = getAttributeValue(e, "scopeSelect");
				xd.getDbConf().addField(i, fieldName, type, typeLength, comments, defValue, scopeSelect);
			}
		}
		return xd;
	}
	
	private static String getSubElementValue(Element e, String name) {
		Element se = e.element(name);
		if(se != null) {
			return se.getStringValue();
		}
		return "";
	}
	
	private static String getElementValue(Element e) {
		if(e == null){
			return "";
		}
		return e.getStringValue();
	}

	private static String getAttributeValue(Element e, String name) {
		if(e == null){
			return "";
		}
		return e.attributeValue(name);
	}
	
	
	
	
}
