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
	
	private int b_code; // �Խ��� ��ȣ
	private String b_name; // �� ����
	private String b_writer; // �� �ۼ���
	private String b_contents; // �� ����
	private String b_password; // �� ���
	private String b_comment; // �� ���
	
	
	
	
	
}
