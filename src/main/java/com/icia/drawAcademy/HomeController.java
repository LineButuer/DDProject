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
	// �α׾ƿ�
	@GetMapping("logout")
	public String logout(HttpSession session, RedirectAttributes rttr) {
	    log.info("logout");
	    String msg = "�α׾ƿ� ����";
	    // ���ǿ��� "login" �Ӽ����� ����
	    session.removeAttribute("login");

	    // �α׾ƿ� �� �α��� �������� �����̷�Ʈ
	    rttr.addFlashAttribute("msg",msg);
	    return "redirect:/";
	}

	// --------------------------------------------------------------------------------//
	@GetMapping("mypage")
	public String mypage(Model model, HttpSession session) {
	    log.info("mypage()");
	   
	    // ���ǿ��� �α����� ȸ�� ������ ������
	    MemberDto loggedInMember = (MemberDto) session.getAttribute("login");

	    if (loggedInMember != null) {
	        // �α����� ȸ�� ������ �𵨿� �߰��Ͽ� JSP�� ����
	        model.addAttribute("loggedInMember", loggedInMember);
	        
	       
	        return "mypage";
	    } else {
	        // �α����� ȸ�� ������ ������ �α��� �������� �����̷�Ʈ
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
//		// service���� ����� �����;���./
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




