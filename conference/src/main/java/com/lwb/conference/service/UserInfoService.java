package com.lwb.conference.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwb.conference.dao.UserInfoRepository;
import com.lwb.conference.dao.repository.AccountInfoRepository;
import com.lwb.conference.entity.AccountInfo;
import com.lwb.conference.entity.UserInfo;

@Service
@Transactional
public class UserInfoService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private UserInfoRepository ur;
	
	@Autowired
	private AccountInfoRepository ar;
	
	public void add(UserInfo user){
		ur.save(user);
	}
	
	public List<UserInfo> findByName(String name){
		return ur.findByName(name);
	}
	
	
	public void saveAccount(AccountInfo info){
		ar.save(info);
	}
	
}
