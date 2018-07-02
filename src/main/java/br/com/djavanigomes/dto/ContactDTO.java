package br.com.djavanigomes.dto;

import java.io.Serializable;

import br.com.djavanigomes.domain.User;

public class ContactDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String userId;
	
	private String userName;
	
	private User contact;
	
	public ContactDTO() {
	
	}	

	public ContactDTO(String id, String userId, String userName, User contact) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.contact = contact;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User getContact() {
		return contact;
	}

	public void setContact(User contact) {
		this.contact = contact;
	}	

}
