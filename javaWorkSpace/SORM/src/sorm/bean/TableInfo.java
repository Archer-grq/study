package sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * 存储表结构的信息
 * @author HASEE
 *
 */
public class TableInfo {
	/**
	 * 表的名称
	 */
	private String tName;
	/**
	 * 所有字段的信息
	 */
	private Map<String,ColumnInfo> columsMap;
	/**
	 * 唯一主键（目前我们只能处理表中有且只有一个主键的情况）
	 */
	private ColumnInfo onlyPriKey;
	
	/**
	 * 如果联合主键，则在这里存储
	 */
	private List<ColumnInfo> priKeys;   
	
	public TableInfo(String tName, List<ColumnInfo> priKeys, Map<String, ColumnInfo> columsMap) {
		super();
		this.tName = tName;
		this.columsMap = columsMap;
		this.priKeys = priKeys;
	}
	public TableInfo(String tName, Map<String, ColumnInfo> columsMap, ColumnInfo onlyPriKey, List<ColumnInfo> priKeys) {
		super();
		this.tName = tName;
		this.columsMap = columsMap;
		this.onlyPriKey = onlyPriKey;
		this.priKeys = priKeys;
	}
	public List<ColumnInfo> getPriKeys() {
		return priKeys;
	}
	public void setPriKeys(List<ColumnInfo> priKeys) {
		this.priKeys = priKeys;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public Map<String, ColumnInfo> getColumsMap() {
		return columsMap;
	}
	public void setColumsMap(Map<String, ColumnInfo> columsMap) {
		this.columsMap = columsMap;
	}
	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}
	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}
	public TableInfo(String tName, Map<String, ColumnInfo> columsMap, ColumnInfo onlyPriKey) {
		super();
		this.tName = tName;
		this.columsMap = columsMap;
		this.onlyPriKey = onlyPriKey;
	}
	
	public TableInfo() {
	}

}
