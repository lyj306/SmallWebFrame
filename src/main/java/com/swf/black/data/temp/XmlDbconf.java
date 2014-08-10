package com.swf.black.data.temp;

import com.swf.util.StringUtil;



//<table>wine</table>
//<key>id</key>
//<fields>
//	<id type="int" comments="ID"/>
//	<name type="String" comments="酒名字" />
//	<content type="String" comments="描述" />
//	<price type="float" default="1000" comments="价格"  />
//	<dis_price type="float" default="1000" comments="折扣价" />
//	<birthday type="int" default="0" comments="出厂日期"  />
//	<feel type="byte" default="1" scope="1,2,3,4" scopeSelect="1-甘甜,2-浓重,3-酸甜,4-顺滑" comments="口感" />
//	<flavor type="byte" default="1" scope="1,2,3,4" scopeSelect="1-酱香,2-浓香,3-清香,4-米香" comments="香型" />
//	<degree type="byte" default="50" comments="度数"  />
//	<uses type="byte" default="1" scope="1,2,3,4" scopeSelect="1-送礼,2-聚会,3-婚宴,4-商务" comments="用途"  />
//	<meat type="byte" default="1" scope="1,2,3,4" scopeSelect="1-湘菜,2-川菜,3-粤菜,4-鲁菜" comments="配餐" />
//</fields>

public class XmlDbconf {

	private String table;
	private String key;
	private XmlDbFieldConf[] fields;
	

	public void initFiledSize(int len) {
		fields = new XmlDbFieldConf[len];
	}
	
	public void addField(int index, String fieldName, String type, String typeLength,
				String comments, String defValue, String scopeSelect ) {
		fields[index] = new XmlDbFieldConf();
		fields[index].setFieldName(fieldName);
		fields[index].setType(type);
		fields[index].setTypeLength(StringUtil.parseInt(typeLength));
		fields[index].setComments(comments);
		fields[index].setDefValue(defValue);
		fields[index].setScopeValues(scopeSelect);
	}
	
	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	
	
	public XmlDbFieldConf[] getFields() {
		return fields;
	}

	public void setFields(XmlDbFieldConf[] fields) {
		this.fields = fields;
	}
	
}
