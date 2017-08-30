package com.zhaoziqian.houseinfo.pojo;

import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable {

	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	
	private static final long serialVersionUID = 3996926965066924433L;
	/**
	 * 身份证号 使用身份证号作为ID
	 */
	private String cardId;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别 根据身份证号倒数第二位判断，单数时该字段填1（表示男），双数时该字段填0（表示女）
	 */
	private Integer sex;
	/**
	 * 最后修改时间
	 */
	private Date lastModifyTime;
	/**
	 * 密码 长度6位（含）以上
	 */
	private String password;
	/**
	 * 用户状态 1为正常，0为冻结，默认为1
	 */
	private Integer status;
	
	public Users() {}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Users [cardId=" + cardId + ", name=" + name + ", sex=" + sex + ", lastModifyTime=" + lastModifyTime
				+ ", password=" + password + ", status=" + status + "]";
	}
	
	
	
	
}
