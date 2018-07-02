package br.com.djavanigomes.dto;

import java.io.Serializable;

import br.com.djavanigomes.domain.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String name;
	
	private String email;
	
	private String phone;
	
	private String mobilePhone;
	
	private boolean isWhatsapp;
	
	private String whatsapp;
	
	public UserDTO() {
	
	}
	
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
		phone = obj.getPhone();
		mobilePhone = obj.getMobilePhone();		
		setWhatsapp(obj.isWhatsapp());	
		
		whatsapp = (obj.isWhatsapp()?"SIM":"NÃO");	
		
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public boolean isWhatsapp() {
		return isWhatsapp;
	}

	public void setWhatsapp(boolean isWhatsapp) {
		this.isWhatsapp = isWhatsapp;
	}

}
