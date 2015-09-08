package com.lwb.conference.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lwb.conference.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

	public List<UserInfo> findByName(String name);
}
