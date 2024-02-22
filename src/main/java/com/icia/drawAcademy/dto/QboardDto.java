package com.icia.drawAcademy.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Alias("QueDTO")
public class QboardDto {
	
	private int b_code; // 게시판 번호
	private Integer m_id; // 회원 번호
	private String b_title; // 글 제목
	private String b_contents; // 글 내용
	private String b_password; // 글 비번
}
