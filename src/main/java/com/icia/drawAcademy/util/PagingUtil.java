package com.icia.drawAcademy.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PagingUtil {

	private int maxNum; // 전체 컨텐츠 저장 변수
	private int pageNum; // 현재 보이는 페이지의 번호 저장 변수
	private int listCnt; // 한 페이지 당 보일 컨텐츠 개수 저장 변수
	private int pageCnt; // 보여질 페이지 번호 저장 변수

	// 페이징용 html 코드를 만드는 메소드
	public String makePaging() {
		String pageStr = null;
		StringBuffer sb = new StringBuffer();

		// 1. 전체 페이지 개수 구하기

		int totalPage = (maxNum % listCnt) > 0 ? maxNum / listCnt + 1 : maxNum / listCnt;

		// 2.현재 페이지 그룹 구하기
		int curGroup = (pageNum % pageCnt) > 0 ? pageNum / pageCnt + 1 : pageNum / pageCnt;

		// 3.번호 그릅의 시작 번호
		int start = (curGroup * pageCnt) - (pageCnt - 1);

		// 4.번호 그룹의 마지막 번호
		int end = (curGroup * pageCnt) >= totalPage ? totalPage : curGroup * pageCnt;

		// 5.이전 버튼 처리
		if (start != 1) {
			sb.append("<a class='pno' href='./?pageNum");
			sb.append((start - 1) + "'>");
			sb.append("이전</a>");
		}

		// 6. 중간 번호 버튼 처리
		for (int i = start; i <= end; i++) {
			if (pageNum != i) {
				sb.append("<a class='pno' href='./?pageNum=");
				sb.append(i + "'>" + i + "</a>");
			} else {
				sb.append("<font class='pno'>" + i + "</font>");
			}
		}

		// 7. 다음 버튼 처리
		if (end != totalPage) {
			sb.append("<a class='pno' href='./?pageNum=");
			sb.append((end + 1) + "'>");
			sb.append("다음</a>");
		}

		// StringBuffer에 저장된 내용을 문자열로 변환
		pageStr = sb.toString();
		return pageStr;

	}
}
