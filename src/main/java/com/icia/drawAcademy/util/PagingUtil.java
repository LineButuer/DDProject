package com.icia.drawAcademy.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PagingUtil {
	
	private int maxNum; // ��ü ������ ���� ����
	private int pageNum; // ���� ���̴� �������� ��ȣ ���� ����
	private int listCnt;  // �� ������ �� ���� ������ ���� ���� ����
	private int pageCnt; // ������ ������ ��ȣ ���� ����
	
	// ����¡�� html �ڵ带 ����� �޼ҵ�
	public String makePaging() {
		String pageStr = null;
		StringBuffer sb = new StringBuffer();
		
		//1. ��ü ������ ���� ���ϱ�
		
		int totalPage=(maxNum % listCnt) > 0 ?
				maxNum / listCnt +1 :
				maxNum / listCnt;
	
		int curGroup=(pageNum % pageCnt)>0?
				pageNum/pageCnt+1:
				pageNum/pageCnt;
		
		
		return pageStr;
		
		
		
		
		}
	

	
}
