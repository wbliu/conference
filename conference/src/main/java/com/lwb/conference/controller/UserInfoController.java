package com.lwb.conference.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lwb.conference.entity.AccountInfo;
import com.lwb.conference.entity.AreaInfo;
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
	
	@RequestMapping("/query")
	public String queryUser(HttpServletRequest request){
		String name = request.getParameter("name");
		List<UserInfo> list = us.findByName(name);
		for(UserInfo info : list){
			System.out.println(info.getId()+","+info.getName());
		}
		return "index";
	}
	
	@RequestMapping("/accounts/add")
	public String addAccount(HttpServletRequest request){
		String account = request.getParameter("act");
		AccountInfo info = new AccountInfo();
		info.setAccount(account);
		info.setCompanyID(1);
		info.setCompanyName("name");
		List<AreaInfo> areaInfos = new ArrayList<AreaInfo>();
		AreaInfo area = new AreaInfo();
		area.setId(123);
		area.setName("xiaoqu");
		areaInfos.add(area);
		info.setAreaInfos(areaInfos);
		us.saveAccount(info);
		return "index";
	}
}
