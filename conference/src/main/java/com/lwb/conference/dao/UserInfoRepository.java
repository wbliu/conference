package com.lwb.conference.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lwb.conference.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

}
