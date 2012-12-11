package org.wmichina.crm.helper;

public class XLSField {
	String fieldName;
	String fieldMapping;
	String fieldType;
	int fieldLength;
	String tableName;
	boolean isRequired;

	public XLSField(String fieldName, String fieldMapping, String fieldType,int fieldLength,
			String tableName, boolean isRequired){
		this.fieldName = fieldName;
		this.fieldMapping = fieldMapping;
		this.fieldType = fieldType;
		this.fieldLength = fieldLength;
		this.tableName = tableName;
		this.isRequired = isRequired;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldMapping() {
		return fieldMapping;
	}

	public void setFieldMapping(String fieldMapping) {
		this.fieldMapping = fieldMapping;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public boolean isRequired() {
		return isRequired;
	}

	public void setRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}

	public int getFieldLength() {
		return fieldLength;
	}

	public void setFieldLength(int fieldLength) {
		this.fieldLength = fieldLength;
	}
	
}
