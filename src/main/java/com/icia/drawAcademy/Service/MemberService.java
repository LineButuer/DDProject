package com.icia.drawAcademy.Service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.drawAcademy.dao.MemberDao;
import com.icia.drawAcademy.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;

@Service("mServ")
@Slf4j
public class MemberService {

	@Autowired
	private MemberDao mDao;

	// ȸ������
	public String signUp(MemberDto member, HttpSession session, RedirectAttributes rttr) {
		log.info("signUp()");
		String msg = null; // DB ���� ����/���� ���� �޽��� ����
		String view = null; // ��� ������ ���� ����

		try {
			mDao.signUp(member); // ���� ����
			System.out.println("member" + member);
			view = "redirect:/?";
			msg = "ȸ������ ����";

		} catch (Exception e) { // ���� ����
			e.printStackTrace();
			view = "redirect:/?";
			msg = "ȸ������ ����";
		}

		rttr.addFlashAttribute("msg", msg);
		System.out.println(msg);
		return view;
	}

	// �α���
	public String login(MemberDto memberDto, HttpSession session, RedirectAttributes rttr) {
		log.info("login()");
		String msg = null;
		String view = null;
		MemberDto loggedInMember= mDao.login(memberDto);

		if (loggedInMember != null) {
//			mDao.login(m_email, m_password);
			msg = "�α��� ����";
			view = "redirect:/";
			
			System.out.println(loggedInMember);
		//	�α��ν� ���ǿ� ����
			session.setAttribute("login", loggedInMember);

		} else {
			msg = "�α��� ����/ �̸��� �� ��й�ȣ�� �ٽ� Ȯ�����ֽñ� �ٶ��ϴ�.";
			view = "redirect:login";
		}
		rttr.addFlashAttribute("msg", msg);
		return view;

	}
	
	public String logout(HttpSession session, RedirectAttributes rttr) {
		log.info("logout()");
		String msg = "�α׾ƿ� ����";
		
		session.removeAttribute("login");
		
		rttr.addFlashAttribute("msg",msg);
		return "redirect:/";
	}
}