package com.icia.drawAcademy.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.drawAcademy.dao.CmtDao;
import com.icia.drawAcademy.dao.QboardDao;
import com.icia.drawAcademy.dto.CmtDto;
import com.icia.drawAcademy.dto.MemberDto;
import com.icia.drawAcademy.dto.QboardDto;
import com.icia.drawAcademy.util.PagingUtil;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;


@Service("Qserv")
public class QboardService {

	@Autowired
	private QboardDao qDao;

	@Autowired
	private CmtDao cDao;
	
	
	public String getQboardList(Integer pageNum, Model model, HttpSession session) {

		if (pageNum == null) {
			pageNum = 1;
		}

		int listCnt = 10; // 페이지당 보여지는 개수

		Map<String, Integer> pMap = new HashMap<String, Integer>();
		pMap.put("pageNum", (pageNum - 1) * listCnt);
		pMap.put("listCnt", listCnt);

		List<QboardDto> qList = qDao.getQboardList(pMap);

		model.addAttribute("qList", qList);
		System.out.println(qList);
		System.out.println(pMap);
		// 페이징 처리
		String pageHtml = getPaging(pageNum, listCnt);
		model.addAttribute("paging", pageHtml);

		session.setAttribute("pageNum", pageNum);

		return "qboard";

	}

	private String getPaging(Integer pageNum, Integer listCnt) {
		String pageHtml = null;

		// 전체 게시물 개수
		int maxNum = qDao.cntQboard();
		// 페이지당 보여질 번호 개수
		int pageCnt = 5;

		PagingUtil paging = new PagingUtil(maxNum, pageNum, listCnt, pageCnt);

		pageHtml = paging.makePaging();

		return pageHtml;

	}

	// 게시물 작성
	public String insertQBoard(QboardDto qboard, HttpSession session, RedirectAttributes rttr) {

		String msg = "";
		String view = "";

		try {
			qDao.insertQBoard(qboard);
			System.out.println("qboard" + qboard);
			view = "redirect:qboard?msg="+msg;
			msg = "게시물 등록 성공";

		} catch (Exception e) {
			e.printStackTrace();
			view = "redirect:qboard?msg="+msg;
			msg = "게시물 등록 실패";
		}

		rttr.addFlashAttribute("msg", msg);
		System.out.println(msg);
		return view;
	}

	public void getQBoard(Integer b_code, Model model) {
		QboardDto qboard = qDao.selectQBoard(b_code);
		
		List<CmtDto> cList = cDao.getCommentList(b_code);

		model.addAttribute("qboard", qboard);
		model.addAttribute("cList", cList);
		
		System.out.println(model);

	}
	
	// 게시믈 수정 ----------------------------------------------------------------------------------------------------------------

	public String getQBUpdate(QboardDto qboard, HttpSession session, RedirectAttributes rttr) {
			
		System.out.println("수정시작");
		String view = null;
		String msg = null;

		
		
		try {
			qDao.updateQBoard(qboard);
			System.out.println("qboard" + qboard);
			msg = "게시물 수정 성공";
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "수정 실패.";

		}
		view = "redirect:qboard?b_code=" + qboard.getB_code();
		return view;
	}

	public String boardDelete(Integer b_code, HttpSession session, RedirectAttributes rttr) {
		
		System.out.println("삭제중");
		
		String view =null;
		String msg = null;
		
		QboardDto qboard=qDao.selectQBoard(b_code);
		
		try {
			
			qDao.deleteQBoard(b_code);
			
			view="redirect:/?qboard";
			msg="삭제 성공";
					
		} catch (Exception e) {
			e.printStackTrace();
			view="redirect:/?qboard";
			msg="삭제 실패";
		}
		
		rttr.addFlashAttribute("msg", msg);
		
		return view;
	}

	
}
