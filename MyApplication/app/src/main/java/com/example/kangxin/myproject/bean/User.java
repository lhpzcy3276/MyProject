package com.example.kangxin.myproject.bean;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

public class User extends RealmObject {
	public User() {
	}

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	private String name ;
	private String email  ;
	@PrimaryKey
	private String id;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", email='" + email + '\'' +
				", id='" + id + '\'' +
				'}';
	}
}
