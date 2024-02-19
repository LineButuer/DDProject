package com.icia.drawAcademy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;

import com.icia.drawAcademy.dto.QboardDto;

public interface QboardDao {
	
	// 게시판 목록 가져오기
	List<QboardDto> getQboardList(Map<String, Integer> pMap);

	// 전체 게시물 개수 구하기
	@Select("SELECT count(*) FROM Qboard")
	int cntQboard();
	
	// 게시물 정보 입력
	void insertQBoard(QboardDto qboard);
	
	
}
