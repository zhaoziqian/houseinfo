package com.zhaoziqian.houseinfo.vo;

import java.io.Serializable;
import java.util.Date;

import com.zhaoziqian.houseinfo.pojo.RealEstate;


public class HouseVo extends RealEstate implements Serializable{

	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	
	private static final long serialVersionUID = -2321378254891123214L;
	/**
	 * 产权人姓名
	 */
	private String name ;
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
	private String projectName;
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
	public HouseVo() {}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
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
		return "HouseVo [name=" + name + ", id=" + id + ", cardId=" + cardId + ", projectName=" + projectName
				+ ", address=" + address + ", houseType=" + houseType + ", area=" + area + ", buildTime=" + buildTime
				+ "]";
	}
	
	
}
