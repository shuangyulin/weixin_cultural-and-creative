package com.dao;

import com.entity.YuyinjiangjieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuyinjiangjieVO;
import com.entity.view.YuyinjiangjieView;


/**
 * 语音讲解
 * 
 * @author 
 * @email 
 * @date 2025-03-01 09:55:52
 */
public interface YuyinjiangjieDao extends BaseMapper<YuyinjiangjieEntity> {
	
	List<YuyinjiangjieVO> selectListVO(@Param("ew") Wrapper<YuyinjiangjieEntity> wrapper);
	
	YuyinjiangjieVO selectVO(@Param("ew") Wrapper<YuyinjiangjieEntity> wrapper);
	
	List<YuyinjiangjieView> selectListView(@Param("ew") Wrapper<YuyinjiangjieEntity> wrapper);

	List<YuyinjiangjieView> selectListView(Pagination page,@Param("ew") Wrapper<YuyinjiangjieEntity> wrapper);

	
	YuyinjiangjieView selectView(@Param("ew") Wrapper<YuyinjiangjieEntity> wrapper);
	

}
