package com.zhaoziqian.houseinfo.service.impl;

import java.util.Date;

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

	@Override
	public Users createUserByInfo(String cardId, String name, String password) {
		Users user = new Users();
		
		// 获得身份证号倒数第二位的字符
		char sexNum = cardId.charAt(cardId.length() - 2);
		int num = Integer.parseInt(String.valueOf(sexNum));
		int sex = 1; // 1 为男  0 为女
		if (num % 2 == 0) {
			sex = 0;
		}
		user.setCardId(cardId);
		user.setName(name);
		user.setSex(sex);
		user.setPassword(password);
		user.setLastModifyTime(new Date());
		user.setStatus(1);
		
		
		return user;
	}


}
