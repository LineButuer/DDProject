package com.icia.drawAcademy;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.icia.drawAcademy.Service.CmtService;
import com.icia.drawAcademy.Service.MemberService;
import com.icia.drawAcademy.Service.QboardService;
import com.icia.drawAcademy.dto.CmtDto;
import com.icia.drawAcademy.dto.MemberDto;
import com.icia.drawAcademy.dto.QboardDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@Autowired
	@Qualifier("cServ")
	private CmtService cServ;
	
	@Autowired
	@Qualifier("mServ")
	private MemberService mServ;

	@Autowired
	@Qualifier("Qserv")
	private QboardService Qserv;

	// --------------------------------------------------------------------------------//
	@GetMapping("/")
	public String home(Model model) {
		log.info("home()");

		return "home";

	}

	// --------------------------------------------------------------------------------//
	@GetMapping("signUp")
	public String signUp() {
		log.info("signUp()");

		return "signUp";
	}

	@PostMapping("signUpProc")
	public String signUpProc(MemberDto memberDto, HttpSession session, RedirectAttributes rttr) {
		log.info("signUpProc()");
		String view = mServ.signUp(memberDto, session, rttr);
		System.out.println("rttr = " + rttr);

		return view;
	}

	// --------------------------------------------------------------------------------//
	@GetMapping("login")
	public String login() {
		log.info("login()");
		return "login";
	}

	@PostMapping("loginProc")
	public String loginProc(MemberDto memberDto, HttpSession session, RedirectAttributes rttr) {
		log.info("loginProc()");

		String view = mServ.login(memberDto, session, rttr);
//		    System.out.println(view);
//		    if(view.startsWith("redirect:")) {
//		    	return view;
//		    }else {
//		    	return "login";
//		    }
		return view;
	}

	// --------------------------------------------------------------------------------//
	// 로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session, RedirectAttributes rttr) {
		log.info("logout");
		String msg = "로그아웃 성공";
		// 세션에서 "login" 속성만을 제거
		session.removeAttribute("login");

		// 로그아웃 후 로그인 페이지로 리다이렉트
		rttr.addFlashAttribute("msg", msg);
		return "redirect:/";
	}

	// --------------------------------------------------------------------------------//
	@GetMapping("mypage")
	public String mypage(Model model, HttpSession session) {
		log.info("mypage()");

		// 세션에서 로그인한 회원 정보를 가져옴
		MemberDto loggedInMember = (MemberDto) session.getAttribute("login");

		if (loggedInMember != null) {
			// 로그인한 회원 정보를 모델에 추가하여 JSP로 전달
			model.addAttribute("loggedInMember", loggedInMember);

			return "mypage";
		} else {
			// 로그인한 회원 정보가 없으면 로그인 페이지로 리다이렉트
			return "redirect:/login";
		}
	}

	// --------------------------------------------------------------------------------//
	@GetMapping("setting")
	public String setting() {
		log.info("setting()");
		return "setting";
	}

// 질문 게시판
	// 게시물
	// 목록------------------------------------------------------------------------//
	@GetMapping("qboard")
	public String qboardString(Integer pageNum, Model model, HttpSession session) {

		// service에서 기능을 가져와야함./

		log.info("qboard()");

		String view = Qserv.getQboardList(pageNum, model, session);

		return view;
	}

	// 게시물 작성---------------------------------------------------
	@GetMapping("qwrite")
	public String qBoardWrite() {
		log.info("qwirte()");

		return "qwrite";
	}

	// 게시물 작성----------------------------------------------------------------
	@PostMapping("qwriteProc")
	public String qwriteProc(QboardDto qboard, HttpSession session, RedirectAttributes rttr) {

		String view = Qserv.insertQBoard(qboard, session, rttr);
		return view;
	}

	@GetMapping("detail")
	public String detail(Integer b_code, Model model) {
		log.info("detail()");
		Qserv.getQBoard(b_code, model);
		//cServ.commentList(model, session, pageNum);	
		return "detail";
	}

	// 게시물 수정-------------------------------------------------------
	@GetMapping("QBUpdate")
	public String qboardUpdateString(Integer b_code, Model model) {
		log.info("QBUpdate()");
		Qserv.getQBoard(b_code, model);
		return "QBUpdate";
	}

	@PostMapping("QBUpdateProc")
	public String QBUdateProc(QboardDto qboard, HttpSession session, RedirectAttributes rttr) {
		log.info("QBUpdateProc()");
		String view = Qserv.getQBUpdate(qboard, session, rttr);
		return view;
	}
	
	
	// 게시물 삭제
	@PostMapping("delete")
	public String boardDelete (Integer b_code,
							HttpSession session,
							RedirectAttributes rttr) {
		String view=Qserv.boardDelete(b_code, session, rttr);
		
		return view;
	}
	
	// 게시물 댓글 달기
	@PostMapping("inscProc")
	public String insertCmt (CmtDto cDto,
							//QboardDto qDto,
							HttpSession session,
							RedirectAttributes rttr) {
		
		String view = cServ.insertCmt(cDto, session, rttr);
		
		return view;
	}
	// 댓글 리스트 
	
//	@GetMapping("comment")
//	public String commentList (Model model,HttpSession session) { 
//	
//		log.info("commentList()");
//		String view = cServ.commentList(model, session);	
//		
//		return view;
//	}
	
	
	
	
	
}
