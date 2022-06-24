package com.spring.boot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int authorId;
	String authorFirstName;
	String authorLastName;
	String authorLanguage;

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public String getAuthorLanguage() {
		return authorLanguage;
	}

	public void setAuthorLanguage(String authorLanguage) {
		this.authorLanguage = authorLanguage;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorFirstName=" + authorFirstName + ", authorLastName="
				+ authorLastName + ", authorLanguage=" + authorLanguage + "]";
	}

}
