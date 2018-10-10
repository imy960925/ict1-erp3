package com.ict.erp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.erp.dao.LevelDAO;
import com.ict.erp.service.LevelService;
import com.ict.erp.vo.LevelInfo;

@Service
public class LevelServiceImpl implements LevelService {
	
	@Autowired
	private LevelDAO ldao;
	
	@Override
	public List<LevelInfo> getLevelInfoList(LevelInfo li) {
		// TODO Auto-generated method stub
		return ldao.getLevelInfoList(li);
	}

	@Override
	public int insertLevelInfo(LevelInfo li) {
		// TODO Auto-generated method stub
		return ldao.insertLevelInfo(li);
	}

	@Override
	public int updateLevelInfo(LevelInfo li) {
		// TODO Auto-generated method stub
		return ldao.updateLevelInfo(li);
	}

	@Override
	public int deleteLevelInfo(int liNum) {
		// TODO Auto-generated method stub
		return ldao.deleteLevelInfo(liNum);
	}


	@Override
	public LevelInfo getLevelInfo(Integer liNum) {
		// TODO Auto-generated method stub
		return ldao.getLevelInfo(liNum);
	}

}
