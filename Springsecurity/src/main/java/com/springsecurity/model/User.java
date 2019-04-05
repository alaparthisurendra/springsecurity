package com.springsecurity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Table(name = "User")
@Data
public class User {

	@Id
	@Column(name = "USERID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "PASSWORD")
	private String passWord;

}
