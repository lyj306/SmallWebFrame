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
		
		List<Element> fieldList = dbConfElement.elements("fields");
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
	
	/*
	<root>
	<dbconf>
		<table>wine</table>
		<key>id</key>
		<fields>
			<id type="int" comments="ID"/>
			<name type="String" comments="酒名字" />
			<content type="String" comments="描述" />
			<price type="float" default="1000" comments="价格"  />
			<dis_price type="float" default="1000" comments="折扣价" />
			<birthday type="int" default="0" comments="出厂日期"  />
			<feel type="byte" default="1" scope="1,2,3,4" scopeSelect="1-甘甜,2-浓重,3-酸甜,4-顺滑" comments="口感" />
			<flavor type="byte" default="1" scope="1,2,3,4" scopeSelect="1-酱香,2-浓香,3-清香,4-米香" comments="香型" />
			<degree type="byte" default="50" comments="度数"  />
			<uses type="byte" default="1" scope="1,2,3,4" scopeSelect="1-送礼,2-聚会,3-婚宴,4-商务" comments="用途"  />
			<meat type="byte" default="1" scope="1,2,3,4" scopeSelect="1-湘菜,2-川菜,3-粤菜,4-鲁菜" comments="配餐" />
		</fields>
	</dbconf>
</root>
	*/
	
	public static void main(String[] args) {
		read("F:\\workspace1.4\\SmallWebFrame\\src\\main\\resource\\data\\tabale\\");
	}
	
}
