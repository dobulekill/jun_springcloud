package com.frame.auto.code.model;

import com.frame.auto.code.constants.DataType;
import com.frame.auto.code.javabean.StringUtil;

public class Column {
	private String columnName;	//表中的列名
	private String fieldName;	//属性名称
	private int columnType;
	private int length;// 最大长度
	private int nullAble;// 0:不能为空 1：可以为空
	private int isKey;// 1:是主键
	private int autoGeneral;// 1:自动生成或者自动增长
	private String comments;// 列的备注

	private String typeName;
	private String typeNameFull;

	public Column() {
		columnName = "";
		fieldName = "";
		comments = "";
		typeName = "";
		typeNameFull = "";
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * 首字母大写的属性名称
	 * @return
	 */
	public String getFieldNameFupcase() {
		return StringUtil.setFirstCharUpcase(fieldName);
	}

	public int getColumnType() {
		return columnType;
	}

	public void setColumnType(int columnType) {
		this.columnType = columnType;
		this.setTypeName(DataType.DATA_TYPE[this.columnType]);
		this.setTypeNameFull(DataType.DATA_TYPE_FULL[this.columnType]);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getNullAble() {
		return nullAble;
	}

	public void setNullAble(int nullAble) {
		this.nullAble = nullAble;
	}

	public int getIsKey() {
		return isKey;
	}

	public void setIsKey(int isKey) {
		this.isKey = isKey;
	}

	public int getAutoGeneral() {
		return autoGeneral;
	}

	public void setAutoGeneral(int autoGeneral) {
		this.autoGeneral = autoGeneral;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeNameFull() {
		return typeNameFull;
	}

	public void setTypeNameFull(String typeNameFull) {
		this.typeNameFull = typeNameFull;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments == null ? "" : comments;
		this.comments=this.comments.replaceAll("\n", " ");
	}
	
	public String getComments4Page() {
		if(StringUtil.isEmpty(comments)){
			return this.fieldName;
		}
		if(comments.length()>6){
			return comments.substring(0, 6);
		}
		return comments;
	}

}