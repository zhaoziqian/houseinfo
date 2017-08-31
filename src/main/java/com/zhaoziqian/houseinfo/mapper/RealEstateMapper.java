package com.zhaoziqian.houseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhaoziqian.houseinfo.vo.HouseVo;

public interface RealEstateMapper {

	List<HouseVo> selectPages(@Param("type") String type,@Param("value") String value ,@Param("start") Integer start ,@Param("size") Integer size);
	
	int getCount(@Param("type") String type ,@Param("value") String value);
}
