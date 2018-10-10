package com.ict.erp.vo;

import org.apache.ibatis.type.Alias;

@Alias("li")
public class LevelInfo {

	private Integer liNum;
	private Integer liLevel;
	private String liName;
	private String liDesc;
	
	public LevelInfo() {}
	
	public LevelInfo(Integer liNum, Integer liLevel, String liName, String liDesc) {
		super();
		this.liNum = liNum;
		this.liLevel = liLevel;
		this.liName = liName;
		this.liDesc = liDesc;
	}
	public Integer getLiNum() {
		return liNum;
	}
	public void setLiNum(Integer liNum) {
		this.liNum = liNum;
	}
	public Integer getLiLevel() {
		return liLevel;
	}
	public void setLiLevel(Integer liLevel) {
		this.liLevel = liLevel;
	}
	public String getLiName() {
		return liName;
	}
	public void setLiName(String liName) {
		this.liName = liName;
	}
	public String getLiDesc() {
		return liDesc;
	}
	public void setLiDesc(String liDesc) {
		this.liDesc = liDesc;
	}
	@Override
	public String toString() {
		return "LevelInfo [liNum=" + liNum + ", liLevel=" + liLevel + ", liName=" + liName + ", liDesc=" + liDesc + "]";
	}
	
}
