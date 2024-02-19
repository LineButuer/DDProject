package com.icia.drawAcademy;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.drawAcademy.Service.MemberService;
import com.icia.drawAcademy.Service.QboardService;
import com.icia.drawAcademy.dto.MemberDto;
import com.icia.drawAcademy.dto.QboardDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

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
	    rttr.addFlashAttribute("msg",msg);
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

	
	// --------------------------------------------------------------------------------// 
//	@GetMapping("qboard")
//	public String qboardString (Integer pageNum, Model model, HttpSession session) {
//		
//		// service에서 기능을 가져와야함./
//		
//		log.info("qboard()");
//		
//		String view = Qserv.getQboardList(pageNum, model, session);
//		
//		return view;
//	}
//	
	@GetMapping("qwrite")
	public String qBoardWrite() {
		log.info("qwirte()");

		return "qwrite";
	}
	@GetMapping("qwriteProc")
	public String qwriteProc(QboardDto qboardDto, HttpSession session, RedirectAttributes rttr) {
		
		String view = Qserv.insertQBoard(qboardDto, session, rttr);
		return view;
	}
	
	
	
	
	
}




