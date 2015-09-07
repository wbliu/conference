package com.lwb.conference.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lwb.conference.entity.UserInfo;
import com.lwb.conference.service.UserInfoService;

@Controller
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoService us;
	
	@RequestMapping("/add")
	public String addUser(HttpServletRequest request){
		String name = request.getParameter("name");
		UserInfo u = new UserInfo();
		u.setName(name);
		us.add(u);
		return "index";
	}
}
