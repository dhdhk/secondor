package com.spring.second.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.second.member.dto.MemberDTO;
import com.spring.second.member.service.MemberService;
import com.spring.second.write.dto.ImageDTO;

@Controller
@EnableAspectJAutoProxy
public class MemberControllerImpl extends MultiActionController implements MemberController{
	@Autowired
	private MemberService memberService;
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class); 

	@Override
	@RequestMapping(value="/member/listMembers.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		String viewName = (String) request.getAttribute("viewName");
		List<MemberDTO> membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);

		logger.info("viewName : " + viewName);
		logger.debug("viewName : " + viewName);

		mav.addObject("membersList", membersList);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/addMember.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView addMember(@ModelAttribute("member") MemberDTO member,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub



		memberService.addMember(member);

		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}

	@Override
	@RequestMapping(value="/member/removeMember.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView removeMember(@RequestParam("user_id") String id,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");

		return mav;
	}

	@Override
	@RequestMapping(value="/member/*Form.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);

		return mav;
	}

	@Override
	@RequestMapping(value="/member/modMemberForm.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView modMemberForm(@RequestParam("user_id") String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println(id);
		MemberDTO dto = memberService.selectMember(id);

		String viewName = (String) request.getAttribute("viewName");

		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("member", dto);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/modMember.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView modMember(@ModelAttribute("member") MemberDTO member, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		memberService.modMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");

		return mav;
	}

	@Override
	@RequestMapping(value="/member/login.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(@ModelAttribute("member") MemberDTO member, 
			RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		member = memberService.login(member);
		ModelAndView mav = new ModelAndView();

		if(member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			session.setAttribute("isLogOn", true);
			rAttr.addAttribute("msg", "login");
			String action = (String) session.getAttribute("action");
			session.removeAttribute("action");

			if(action != null) {
				mav.setViewName("redirect:"+action);
			} else {
				mav.setViewName("redirect:/main.do");
			}
		} else {
			rAttr.addAttribute("result", "loginfailed");
			mav.setViewName("redirect:/member/loginForm.do");
		}
		return mav;
	}

	@Override
	@RequestMapping(value="/member/logout.do",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView logout(RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		Boolean isLogOn = (Boolean) session.getAttribute("isLogOn");

		ModelAndView mav = new ModelAndView();

		if(session != null && isLogOn != null) {			
			session.invalidate();
			rAttr.addAttribute("result", "logout");
		} else {
			rAttr.addAttribute("result", "notLogin");
		}
		mav.setViewName("redirect:/main.do");
		return mav;
	}

	@Override
	@RequestMapping(value="/member/findIdForm.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView findIdForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/member/findIdForm");
		return mav;
	}

	@Override
	@RequestMapping(value="/member/findId.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView findId(RedirectAttributes rAttr,
			HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		Map<String, String> searchId=new HashMap<String, String>();
		searchId.put("user_name", user_name);
		searchId.put("user_email", user_email);
		for(String key: searchId.keySet()) {
			String value=(String)searchId.get(key);
			System.out.println(key+" "+value);
		}

		String id = memberService.find_id(searchId);
		request.setAttribute("user_id", id);
		System.out.println("id = " + id);
		ModelAndView mav = new ModelAndView();
		if(id!=null) {
			mav.setViewName("/member/findIdShow");
		}else {
			rAttr.addAttribute("result", "findIdFailed");
			mav.setViewName("redirect:/member/findIdForm.do");
		}
		return mav;
	}

	@Override
	@RequestMapping(value="/member/findIdShow.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView findIdShow(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/findIdShow");
		return mav;
	}

	@Override
	@RequestMapping(value="/member/findPw.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView findPw(RedirectAttributes rAttr,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String user_id = request.getParameter("user_id");
		String user_email = request.getParameter("user_email");
		Map<String, String> searchPw = new HashMap<String, String>();
		searchPw.put("user_id", user_id);
		searchPw.put("user_email", user_email);

		String pw = memberService.find_pw(searchPw);
		request.setAttribute("user_pw", pw);
		ModelAndView mav = new ModelAndView();
		if(pw!=null) {
			mav.setViewName("/member/findPwShow");
		}else {
			rAttr.addAttribute("result", "findPwFailed");
			mav.setViewName("redirect:/member/findPwForm.do");
		}

		return mav;
	}
}