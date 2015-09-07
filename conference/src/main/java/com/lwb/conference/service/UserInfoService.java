package com.lwb.conference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwb.conference.dao.UserInfoRepository;
import com.lwb.conference.entity.UserInfo;

@Service
@Transactional
public class UserInfoService {

	@Autowired
	private UserInfoRepository ur;
	
	public void add(UserInfo user){
		ur.save(user);
	}
	
}
