package kdata.project.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable{
	
	 private String cus_id;
     private String cus_pw;
     private String cus_name;
     private String cus_grade;
     private String cus_addr;
     private String cus_call;
     private String cus_gender;
     
	public CustomerDTO() {
		super();
	}

	public String getCus_id() {
		return cus_id;
	}
	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}
	public String getCus_pw() {
		return cus_pw;
	}
	public void setCus_pw(String cus_pw) {
		this.cus_pw = cus_pw;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public String getCus_grade() {
		return cus_grade;
	}
	public void setCus_grade(String cus_grade) {
		this.cus_grade = cus_grade;
	}
	public String getCus_addr() {
		return cus_addr;
	}
	public void setCus_addr(String cus_addr) {
		this.cus_addr = cus_addr;
	}
	public String getCus_call() {
		return cus_call;
	}
	public void setCus_call(String cus_call) {
		this.cus_call = cus_call;
	}
	public String getCus_gender() {
		return cus_gender;
	}
	public void setCus_gender(String cus_gender) {
		this.cus_gender = cus_gender;
	}
}
