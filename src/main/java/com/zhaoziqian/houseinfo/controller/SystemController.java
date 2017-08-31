package com.zhaoziqian.houseinfo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhaoziqian.houseinfo.pojo.Users;
import com.zhaoziqian.houseinfo.service.RealEstateService;
import com.zhaoziqian.houseinfo.service.RegisterAndLogin;
import com.zhaoziqian.houseinfo.util.EmptyString;
import com.zhaoziqian.houseinfo.vo.HouseVo;

@Controller
public class SystemController {
	
	@Autowired
	private RegisterAndLogin registerAndLogin;
	@Autowired
	private RealEstateService realEstateService;

	@RequestMapping(value="index",method=RequestMethod.GET)
	public String index(HttpSession session){
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
			return "redirect:login";
		}
		
		return "index";
	}
	
	@RequestMapping(value="search")
	public String search(String type, 
						 String value,
						 Integer pageIndex,
						 Integer pageSize,
						 ModelMap map){
		
		// 当一开始是，没有查询参数，和分页信息。所以需要初始化
		if (pageIndex == null || pageIndex <= 0) {
			pageIndex = 1;
		}
		if (pageSize == null || pageSize <= 0) {
			pageSize = 5;
		}
		
		// 计算得到查询时候的起始和结束
		int start = (pageIndex - 1) * pageSize;
		int end = pageIndex * pageSize;
		
		List<HouseVo> houseVos = realEstateService.selectPages(type, value, start, pageSize);
		map.put("houseVos", houseVos);
		for (HouseVo houseVo : houseVos) {
			System.out.println(houseVo);
		}
		
		
		
		return "table";
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:login";
	}
	
	
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(ModelMap map){
		map.put("user", new Users());
		return "login";
	}
	
	@RequestMapping(value="log",produces="application/json")
	@ResponseBody
	public Object loginAjax(@RequestParam("cardId") String cardId ,
							@RequestParam("password") String password ,HttpSession session){
		
		System.out.println(cardId +"\t"+ password);
		Map<String,String> result = new HashMap<>();
		Users temp = registerAndLogin.findUserById(cardId);
		
		if (temp == null) {
			result.put("result", "该账号不存在，请先注册！");
			return result;
		}
		if (!password.equals(temp.getPassword())) {
			result.put("result", "登录失败，身份证或密码错误！");
			return result;
		}
		if (temp.getStatus() != 1) {
			result.put("result", "登录失败，该账号已被冻结！");
			return result;
		}
		
		// 通过以上判断，用户可以登陆，将用户信息保存进session
		session.setAttribute("user", temp);
		
		result.put("result", "success");
		return result;
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
