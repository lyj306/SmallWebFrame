package com.swf.black.data.temp;

import com.swf.black.data.sql.SqlFieldTypeUtil;


public class XmlDbFieldConf {
	private String fieldName;
	private String type;
	private int typeLength;
	private String comments;
	private String defValue;
	private FileScopeValue[] scopeValues;
	

	public void setScopeValues(String scopeSelect) {
		if(scopeSelect != null && !scopeSelect.isEmpty()) {
			String[] scopeArr = scopeSelect.split(",");
			scopeValues = new FileScopeValue[scopeArr.length];
			for (int i=0; i<scopeArr.length; i++) {
				String[] sv = scopeArr[i].split("-");
				scopeValues[i] = new FileScopeValue(sv[0], sv[1]);
			}
		}
	}
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getTypeLength() {
		return typeLength;
	}
	public void setTypeLength(int typeLength) {
		this.typeLength = typeLength;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getDefValue() {
		return defValue;
	}
	public void setDefValue(String defValue) {
		this.defValue = defValue;
	}
	public FileScopeValue[] getScopeValues() {
		return scopeValues;
	}
	public void setScopeValues(FileScopeValue[] scopeValues) {
		this.scopeValues = scopeValues;
	}
	
	public String toSql() {
		StringBuilder buff = new StringBuilder();
		buff.append("`").append(fieldName).append("` ")
			.append(SqlFieldTypeUtil.javaFieldType2SqlFieldType(type, typeLength));
		
		if(defValue != null && !defValue.isEmpty()) {
			buff.append(" DEFAULT '").append(defValue).append("'");
		}
		return buff.toString();
	}
	
	
	
	class FileScopeValue {
		String value;
		String comment;
		
		FileScopeValue(String value, String comment) {
			this.value = value;
			this.comment = comment;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
	}
}
