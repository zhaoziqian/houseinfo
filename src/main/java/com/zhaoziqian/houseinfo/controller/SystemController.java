package com.zhaoziqian.houseinfo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhaoziqian.houseinfo.pojo.Users;
import com.zhaoziqian.houseinfo.service.RegisterAndLogin;

@Controller
public class SystemController {
	
	@Autowired
	private RegisterAndLogin registerAndLogin;

	
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(ModelMap map){
		map.put("user", new Users());
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(Users user ,ModelMap map){
		// 数据回填
		map.put("user", user);
		return "login";
	}
	
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String register(ModelMap map){
		map.put("user", new Users());
		return "register";
	}
	
	/**
	 * 
	* @Title: validCardId 
	* @Description: 验证该身份证号是否可以被注册
	* @param @param cardId
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping(value="cardId.valid",method=RequestMethod.POST)
	@ResponseBody
	public Object validCardId(String cardId){
		System.out.println(cardId);
		Users user = registerAndLogin.findUserById(cardId); 
		if(user != null){
			return false;
		}
		return true;
	}
	
	
	@RequestMapping(value="test",method=RequestMethod.GET)
	public String testPage(){
		
		Users user = registerAndLogin.findUserById("370829199405057242");
		System.out.println(user);
		
		Users tempUser = new Users();
		tempUser.setCardId("620503199006270312");
		tempUser.setName("赵子骞");
		tempUser.setPassword("123456");
		tempUser.setSex(1);
		tempUser.setLastModifyTime(new Date());
		tempUser.setStatus(1);
		
		int result = registerAndLogin.registerUser(tempUser);
		
		System.out.println("是否插入成功："+result);
		
		return "test";
	}
}
