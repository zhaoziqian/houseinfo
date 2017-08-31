package com.zhaoziqian.houseinfo.service;

import java.util.List;

import com.zhaoziqian.houseinfo.vo.HouseVo;

public interface RealEstateService {

	List<HouseVo> selectPages(String type, String value , Integer start ,Integer size);
	
	int getCount(String type , String value);
}
