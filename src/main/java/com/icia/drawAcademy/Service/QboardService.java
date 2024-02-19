package com.icia.drawAcademy.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.drawAcademy.dao.QboardDao;
import com.icia.drawAcademy.dto.QboardDto;
import com.icia.drawAcademy.util.PagingUtil;
import com.mysql.cj.log.Log;

@Service("Qserv")
public class QboardService {

	@Autowired
	private QboardDao qDao;
	
	public String getQboardList(Integer pageNum ,
								Model model,
								HttpSession session) {
		
		if(pageNum==1) {
			pageNum=1;
		}
		
		int listCnt = 10; //페이지당 보여지는 개수
		
		Map<String, Integer> pMap = new HashMap<String, Integer>();
		pMap.put("pageNum", (pageNum-1)*listCnt);
		pMap.put("listCnt", listCnt);
		
		List<QboardDto> qList = qDao.getQboardList(pMap);
		
		model.addAttribute("qList", qList);
		
		//페이징 처리
		String pageHtml= getPaging(pageNum, listCnt);
		model.addAttribute("paging", pageHtml);
		
		session.setAttribute("pageNum", pageNum);
		
		return "qboard";
	
	}
	
	private String getPaging(Integer pageNum, Integer listCnt) {
		String pageHtml=null;
		
		// 전체 게시물 개수
		int maxNum = qDao.cntQboard();
		// 페이지당 보여질 번호 개수
		int pageCnt = 2;

		PagingUtil paging = new PagingUtil(maxNum, 
										pageNum, 
										listCnt, 
										pageCnt);
		
		pageHtml = paging.makePaging();
		
		return pageHtml;
	
	}
	// 게시물 작성
	public String insertQBoard(QboardDto qboard, HttpSession session,
			RedirectAttributes rttr) {
		
		String msg = "";
		String view ="";
		
		try {
			qDao.insertQBoard(qboard);
			System.out.println("qboard" + qboard);
			view = "redirect:/?";
			msg="게시물 등록 성공";
		}
		catch (Exception e) {
			e.printStackTrace();
			view = "redirect:/?";
			msg="게시물 등록 실패";
		}
		
		
		rttr.addFlashAttribute("msg", msg);
		System.out.println(msg);
		return view;
	}
	
	
}
