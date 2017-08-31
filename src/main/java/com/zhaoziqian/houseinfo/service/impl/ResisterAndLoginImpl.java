package com.zhaoziqian.houseinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaoziqian.houseinfo.mapper.UsersMapper;
import com.zhaoziqian.houseinfo.pojo.Users;
import com.zhaoziqian.houseinfo.service.RegisterAndLogin;

@Service
public class ResisterAndLoginImpl implements RegisterAndLogin {

	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public Users findUserById(String id) {
		
		return usersMapper.findUserById(id);
	}

	@Override
	public int registerUser(Users user) {
		
		// 传过来的user对象、只含有 身份证号、密码、姓名、所以需要再服务器补全信息。
		
		return usersMapper.insertUser(user);
	}


}
