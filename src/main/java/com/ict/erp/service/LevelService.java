package com.ict.erp.service;

import java.util.List;

import com.ict.erp.vo.LevelInfo;

public interface LevelService {

	public List<LevelInfo> getLevelInfoList(LevelInfo li);
	public int insertLevelInfo(LevelInfo li);
	public int updateLevelInfo(LevelInfo li);
	public int deleteLevelInfo(int liNum);
	public LevelInfo getLevelInfo(Integer liNum);
}
