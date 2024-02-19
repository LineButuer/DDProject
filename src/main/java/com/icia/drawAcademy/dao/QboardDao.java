package com.icia.drawAcademy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;

import com.icia.drawAcademy.dto.QboardDto;

public interface QboardDao {
	
	// �Խ��� ��� ��������
	List<QboardDto> getQboardList(Map<String, Integer> pMap);

	// ��ü �Խù� ���� ���ϱ�
	@Select("SELECT count(*) FROM Qboard")
	int cntQboard();
	
	// �Խù� ���� �Է�
	void insertQBoard(QboardDto qboard);
	
	
}