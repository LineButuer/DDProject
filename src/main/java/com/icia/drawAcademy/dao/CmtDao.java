package com.icia.drawAcademy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.icia.drawAcademy.dto.CmtDto;
@Repository("cDao")
public interface CmtDao {
	
	// ´ñ±Û ¸®½ºÆ®
	List<CmtDto> getCommentList(int b_code);
	
	void insertCmt(CmtDto cDto);

	@Select("SELECT count(*) FROM cmt")
	int cntcmt();
	
}
