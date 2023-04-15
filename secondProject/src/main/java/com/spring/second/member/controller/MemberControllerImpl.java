package com.spring.second.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.second.member.dto.MemberDTO;
import com.spring.second.member.service.MemberService;
import com.spring.second.write.dto.ImageDTO;

@Controller
@EnableAspectJAutoProxy
public class MemberControllerImpl extends MultiActionController implements MemberController{
	private static final String IMAGE_PATH = "C:\\image";
	@Autowired
	private MemberService memberService;
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class); 

	
	@Override
	@RequestMapping(value="/member/addMember.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ResponseEntity addMember(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> memberMap = new HashMap<String, Object>();
		Enumeration<String> enu = multipartRequest.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = enu.nextElement();
			String value = multipartRequest.getParameter(name);
			System.out.println(name+" : "+value);
			memberMap.put(name, value);
		}
		String filename = upload(multipartRequest);
		System.out.println(filename);
		if(filename.length()==0) {
			filename=null;
		}
		String message;
		ResponseEntity<String> resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html;charset=utf-8");
		String user_id = multipartRequest.getParameter("user_id");
		try {
		
			if(filename==null) {
				memberMap.put("porfileimg", null);
				memberService.addMemberNoimg(memberMap);
			}else {
				
				memberMap.put("profileimg", filename);
				File srcFile = new File(IMAGE_PATH + "\\" + "temp" + "\\" + filename);
				File destDir = new File(IMAGE_PATH + "\\member\\" + user_id);
				FileUtils.moveFileToDirectory(srcFile, destDir, true);
				memberService.addMember(memberMap);
				
			}
			
			message = "<script>";
			message += "alert('회원가입이 완료되었습니다.');";
			message += "location.href='" + multipartRequest.getContextPath() +"/member/loginForm.do';";
			message += "</script>";
			resEnt = new ResponseEntity<String>(message, responseHeaders, HttpStatus.OK);
		
		}catch (Exception e) {
			if(filename!=null) {
				
					File srcFile = new File(IMAGE_PATH + "\\" + "temp" + "\\" + filename);
					srcFile.delete();
				
			}
			
			message = "<script>";
			message += "alert('오류가 발생했습니다. 다시 시도해 주세요.');";
			message += "location.href='" + multipartRequest.getContextPath()
				+"/member/memberForm.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		
			
		return resEnt;
	}

	public String upload(MultipartHttpServletRequest multipartRequest) throws Exception{
		// TODO Auto-generated method stub
		Iterator<String> fileNames = multipartRequest.getFileNames();
		String fileName=fileNames.next();
		MultipartFile mFile = multipartRequest.getFile(fileName);
		String originalFileName = mFile.getOriginalFilename();
			
			File file = new File(IMAGE_PATH+"\\"+originalFileName);
			if(mFile.getSize()!=0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo(new File(IMAGE_PATH+"\\temp\\"+originalFileName));
			}
		
		return originalFileName;
	}

	@Override
	@RequestMapping(value="/member/removeMember.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ResponseEntity removeMember(RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		String id= member.getUser_id();
		memberService.removeMember(id);
		session.removeAttribute("member");
		String message;
		ResponseEntity<String> resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html;charset=utf-8");
		message = "<script>";
		message += "alert('회원 탈퇴가 완료되었습니다.');";
		message += "location.href='" + request.getContextPath() +"/main.do';";
		message += "</script>";
		resEnt = new ResponseEntity<String>(message, responseHeaders, HttpStatus.OK);
		return resEnt;
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

	@Override
	@ResponseBody
	@RequestMapping(value="/member/idCheck.do",  method= {RequestMethod.GET,RequestMethod.POST})
	public String idCheck(@RequestParam("user_id")String id) throws Exception {
		// TODO Auto-generated method stub

		int result = memberService.idCheck(id);
			if(result == 1) {
				return "unusable";
			} else {
				return "usable";
			}		
	}
}