package com.zhaoziqian.houseinfo.mapper;

import java.util.List;

import com.zhaoziqian.houseinfo.pojo.Users;

public interface UsersMapper {

	List<Users> findAll();
	
	List<Users> findByUserInfo(Users user);
	
	Users findUserById(String id);
	
	int insertUser(Users user);
}
