package com.lwb.conference.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lwb.conference.entity.AccountInfo;

public interface AccountInfoRepository extends JpaRepository<AccountInfo, Integer>,JpaSpecificationExecutor<AccountInfo> {

}
