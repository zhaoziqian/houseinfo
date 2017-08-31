package com.zhaoziqian.houseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaoziqian.houseinfo.mapper.RealEstateMapper;
import com.zhaoziqian.houseinfo.service.RealEstateService;
import com.zhaoziqian.houseinfo.vo.HouseVo;
@Service
public class RealRstateServiceImpl implements RealEstateService{

	@Autowired
	private RealEstateMapper realEstateMapper;
	
	@Override
	public List<HouseVo> selectPages(String type, String value, Integer start, Integer size) {
		List<HouseVo> houseVo = realEstateMapper.selectPages(type, value, start, size); 
		return houseVo;
	}

	@Override
	public int getCount(String type, String value) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
