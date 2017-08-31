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
import com.zhaoziqian.houseinfo.util.EmptyString;

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
	
	@RequestMapping(value="regdo",produces="application/json")
	@ResponseBody
	public Object registerAjax( @RequestParam("cardId") String cardId ,
								@RequestParam("name") String name ,
								@RequestParam("password") String password ,
								@RequestParam("confirmPassword") String confirmPassword){
		System.out.println(cardId + "\t" + name + "\t" + password + "\t" + confirmPassword);
		Users temp = registerAndLogin.findUserById(cardId);
		Map<String, String> result = new HashMap<>(); // 用来保存返回数据的map
		// 需要用ajax 返回数据做
		if (EmptyString.isEmpty(cardId)) {
			 result.put("result", "未输入身份证号");
			 return result;
		}
		if (EmptyString.isEmpty(name)) {
			result.put("result", "未输入用户名");
			 return result;
		}
		if (EmptyString.isEmpty(password)) {
			result.put("result", "未输入密码");
			 return result;
		}
		if ( !confirmPassword.equals(password)) {
			result.put("result", "两次密码不一致");
			 return result;
		}
		if (temp != null) {
			result.put("result", "该用户已被注册");
			 return result;
		}
		
		Users user = registerAndLogin.createUserByInfo(cardId, name, password);
		System.out.println(user);
		int resultNum = registerAndLogin.registerUser(user);
		
		if (resultNum != 1) {
			result.put("result", "注册失败");
			return result;
		}
		
		result.put("result", "success");
		 return result;
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register(Users user,String confirmPassword,ModelMap map){
		map.put("user", user);
		System.out.println(user);
		System.out.println("============》确认密码："+confirmPassword);
		Users temp = registerAndLogin.findUserById(user.getCardId());
		Map<String, String> result = new HashMap<>(); // 用来保存返回数据的map
		// 需要用ajax 返回数据做
		if (EmptyString.isEmpty(user.getCardId())) {
			return result.put("result", "未输入身份证号");
		}
		if (EmptyString.isEmpty(user.getName())) {
			return result.put("result", "未输入用户名");
		}
		if (EmptyString.isEmpty(user.getPassword())) {
			return result.put("result", "未输入密码");
		}
		if (temp != null) {
			return result.put("result", "该用户已被注册");
		}
		
//		int result = registerAndLogin.registerUser(user);
		return result.put("result", "success");
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
//		String id = (String) request.getAttribute("cardId");
//		System.out.println("ceshi"+id);
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
