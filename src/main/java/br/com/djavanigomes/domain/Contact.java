package br.com.djavanigomes.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="brvContacts")
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String userId;
	
	private String userName;
	
	private User contact;
	
	public Contact() {
	
	}	

	public Contact(String id, String userId, String userName, User contact) {
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}
