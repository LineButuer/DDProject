package com.icia.drawAcademy.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@Alias("qboard")
public class QboardDto {
	
	private int b_code; // 게시판 번호
	private String b_name; // 글 제목
	private String b_writer; // 글 작성자
	private String b_contents; // 글 내용
	private String b_password; // 글 비번
	private String b_comment; // 글 댓글
	
	
	
	
	
}
