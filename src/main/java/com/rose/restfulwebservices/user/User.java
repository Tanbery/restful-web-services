package com.rose.restfulwebservices.user;

import java.util.Date;

public class User {
	private Integer id;
	private String 	name;
	private Date 	brithDate;
	
	protected User() {}
	
	public User(Integer id, String name, Date brithDate) {
		super();
		this.id = id;
		this.name = name;
		this.brithDate = brithDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBrithDate() {
		return brithDate;
	}

	public void setBrithDate(Date brithDate) {
		this.brithDate = brithDate;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", brithDate=" + brithDate + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getBrithDate()=" + getBrithDate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
}
