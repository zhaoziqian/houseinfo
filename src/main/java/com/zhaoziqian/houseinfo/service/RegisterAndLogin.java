package com.zhaoziqian.houseinfo.service;

import com.zhaoziqian.houseinfo.pojo.Users;

public interface RegisterAndLogin {

	Users findUserById(String id);
	
	int registerUser(Users user);
	
	Users createUserByInfo(String cardId, String name , String password);
}
