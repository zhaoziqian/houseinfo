package com.zhaoziqian.houseinfo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register(Users user,ModelMap map){
		map.put("user", user);
		System.out.println(user);
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
	@RequestMapping(value="cardId.valid",produces="application/json")
	@ResponseBody
	public Object validCardId(@RequestParam("cardId") String cardId,HttpServletRequest request){
		System.out.println(cardId);
		Users user = registerAndLogin.findUserById(cardId); 
		String id = (String) request.getAttribute("cardId");
		System.out.println("ceshi"+id);
		Map<String, Integer> result = new HashMap<>();
		result.put("valid", 1);
		if(user != null){
			result.put("valid", 0);
		}
		return result;
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
