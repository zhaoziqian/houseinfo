package com.zhaoziqian.houseinfo.vo;

import com.zhaoziqian.houseinfo.pojo.RealEstate;


public class HouseVo extends RealEstate{

	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	
	private static final long serialVersionUID = -2321378254891123214L;
	/**
	 * 产权人姓名
	 */
	private String name ;
	public HouseVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "HouseVo [name=" + name + ", getId()=" + getId() + ", getCardId()=" + getCardId()
				+ ", getProject_name()=" + getProject_name() + ", getAddress()=" + getAddress() + ", getHouseType()="
				+ getHouseType() + ", getArea()=" + getArea() + ", getBuildTime()=" + getBuildTime() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
	
}
