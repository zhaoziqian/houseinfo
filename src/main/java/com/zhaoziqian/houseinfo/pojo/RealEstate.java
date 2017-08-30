package com.zhaoziqian.houseinfo.pojo;

import java.io.Serializable;
import java.util.Date;

public class RealEstate implements Serializable {

	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	
	private static final long serialVersionUID = 3268194143991020043L;
	/**
	 * 房产Id
	 */
	private Integer id;
	/**
	 * 产权人身份证号
	 */
	private String cardId;
	/**
	 * 项目名称
	 */
	private String project_name;
	/**
	 * 具体位置
	 */
	private String address;
	/**
	 * 房屋类型 如：两室
	 */
	private String houseType;
	/**
	 * 使用面积
	 */
	private String area;
	/**
	 * 建造时间
	 */
	private Date buildTime;
	
	public RealEstate() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Date getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}

	@Override
	public String toString() {
		return "RealEstate [id=" + id + ", cardId=" + cardId + ", project_name=" + project_name + ", address=" + address
				+ ", houseType=" + houseType + ", area=" + area + ", buildTime=" + buildTime + "]";
	}
	
	
	
	
	
}
