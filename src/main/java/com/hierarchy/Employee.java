package com.hierarchy;

public class Employee {
	public String filler;
	public String empid;
	public String name;
	public String location;
	public String entity;
	public String designation;
	public String skillgroup;
	public String engagementType;
	public String role;
	public String status;
	public String account;
	public String email;
	public String supervisor_email;
	public String supervisor_empid;
	public String master_record;
	
	public String getFiller() {
		return filler;
	}
	public String getEmpid() {
		return empid;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public String getEntity() {
		return entity;
	}
	public String getDesignation() {
		return designation;
	}
	public String getSkillgroup() {
		return skillgroup;
	}
	public String getEngagementType() {
		return engagementType;
	}
	public String getRole() {
		return role;
	}
	public String getStatus() {
		return status;
	}
	public String getAccount() {
		return account;
	}
	public String getEmail() {
		return email;
	}
	public String getSupervisor_email() {
		return supervisor_email;
	}
	public String getSupervisor_empid() {
		return supervisor_empid;
	}
	public String getMaster_record() {
		return master_record;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setSkillgroup(String skillgroup) {
		this.skillgroup = skillgroup;
	}
	public void setEngagementType(String engagementType) {
		this.engagementType = engagementType;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSupervisor_email(String supervisor_email) {
		this.supervisor_email = supervisor_email;
	}
	public void setSupervisor_empid(String supervisor_empid) {
		this.supervisor_empid = supervisor_empid;
	}
	public void setMaster_record(String master_record) {
		this.master_record = master_record;
	}
	@Override
	public String toString() {
		return "SVFBean [filler=" + filler + ", empid=" + empid + ", name=" + name + ", location=" + location
				+ ", entity=" + entity + ", designation=" + designation + ", skillgroup=" + skillgroup
				+ ", engagementType=" + engagementType + ", role=" + role + ", status=" + status + ", account="
				+ account + ", email=" + email + ", supervisor_email=" + supervisor_email + ", supervisor_empid="
				+ supervisor_empid + ", master_record=" + master_record + "]";
	}
	
}
