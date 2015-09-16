package com.lwb.conference.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="account_info")
public class AccountInfo {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String account;

	@Column(name="company_id")
	private Integer companyID;
	
	@Column(name="company_name")
	private String companyName;
	
	@OneToMany
	@JoinTable(name="account_area",
		joinColumns=@JoinColumn(name="account_id",referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="area_id",referencedColumnName="id"))
	private List<AreaInfo> areaInfos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getCompanyID() {
		return companyID;
	}

	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<AreaInfo> getAreaInfos() {
		return areaInfos;
	}

	public void setAreaInfos(List<AreaInfo> areaInfos) {
		this.areaInfos = areaInfos;
	}
	
	
}
