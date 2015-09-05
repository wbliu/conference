package com.lwb.conference.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;
import com.lwb.conference.dao.HelloDao;
import com.lwb.conference.service.HelloService;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

	@Autowired
	private HelloDao helloDao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	@TriggersRemove(cacheName="helloCache",removeAll=true)//清楚缓存
	public void save(Object entity) {
		helloDao.save(entity);
	}

	@Cacheable(cacheName="hellCache")//缓存数据
	public <T> T getById(Class<T> clazz, Object id) {
		return helloDao.getById(clazz, id);
	}


}
