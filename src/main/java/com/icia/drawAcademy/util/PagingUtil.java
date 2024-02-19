package com.icia.drawAcademy.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PagingUtil {
	
	private int maxNum; // 전체 컨텐츠 저장 변수
	private int pageNum; // 현재 보이는 페이지의 번호 저장 변수
	private int listCnt;  // 한 페이지 당 보일 컨텐츠 개수 저장 변수
	private int pageCnt; // 보여질 페이지 번호 저장 변수
	
	// 페이징용 html 코드를 만드는 메소드
	public String makePaging() {
		String pageStr = null;
		StringBuffer sb = new StringBuffer();
		
		//1. 전체 페이지 개수 구하기
		
		int totalPage=(maxNum % listCnt) > 0 ?
				maxNum / listCnt +1 :
				maxNum / listCnt;
	
		int curGroup=(pageNum % pageCnt)>0?
				pageNum/pageCnt+1:
				pageNum/pageCnt;
		
		
		return pageStr;
		
		
		
		
		}
	

	
}
