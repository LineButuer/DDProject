package com.icia.drawAcademy.Service;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.icia.drawAcademy.dao.CmtDao;

import com.icia.drawAcademy.dto.CmtDto;


import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service("cServ")
public class CmtService {

	@Autowired
	@Qualifier("cDao")
	private CmtDao cDao;

	public String insertCmt(CmtDto cDto, HttpSession session,
			RedirectAttributes rttr) {
		log.info("insertCmt()");
		System.out.println("댓글");

		String view = null;
		String msg = null;

		try {
			cDao.insertCmt(cDto);
			System.out.println("CmtDto" + cDto);
			msg = "등록 성공";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "등록 실패";
		}
		
		view = "redirect:detail?b_code=" + cDto.getB_code();
		rttr.addFlashAttribute("msg", msg);

		return view;
	}

}
