package com.ict.erp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ict.erp.vo.LevelInfo;


public interface LevelDAO  {

	public List<LevelInfo> getLevelInfoList(LevelInfo li);
	public LevelInfo getLevelInfo(Integer liNum);
	public int insertLevelInfo(LevelInfo li);
	public int updateLevelInfo(LevelInfo li);
	public int deleteLevelInfo(int liNum);
	
}
