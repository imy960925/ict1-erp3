package com.ict.erp.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.erp.dao.LevelDAO;
import com.ict.erp.vo.LevelInfo;

@Repository
public class LevelDAOImpl implements LevelDAO {
	
	@Autowired
	private SqlSession ss;

	@Override
	public List<LevelInfo> getLevelInfoList(LevelInfo li) {
		return ss.selectList("SQL.LEVELINFO.selectLevelInfo",li);
		
	}
	@Override
	public int insertLevelInfo(LevelInfo li) {
		return ss.insert("SQL.LEVELINFO.insertLevelInfo",li);
	}
	@Override
	public int updateLevelInfo(LevelInfo li) {
		return ss.update("SQL.LEVELINFO.updateLevelInfo",li);
	}
	@Override
	public int deleteLevelInfo(int liNum) {
		return ss.delete("SQL.LEVELINFO.deleteLevelInfo",liNum);
	}
	@Override
	public LevelInfo getLevelInfo(Integer liNum) {
		LevelInfo l = new LevelInfo();
		l.setLiNum(liNum);
		return ss.selectOne("SQL.LEVELINFO.selectLevelInfo",l);
	}
	
	}
	
	


