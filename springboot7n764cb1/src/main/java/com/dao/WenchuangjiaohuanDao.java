package com.dao;

import com.entity.WenchuangjiaohuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WenchuangjiaohuanVO;
import com.entity.view.WenchuangjiaohuanView;


/**
 * 文创交换
 * 
 * @author 
 * @email 
 * @date 2025-03-01 09:55:52
 */
public interface WenchuangjiaohuanDao extends BaseMapper<WenchuangjiaohuanEntity> {
	
	List<WenchuangjiaohuanVO> selectListVO(@Param("ew") Wrapper<WenchuangjiaohuanEntity> wrapper);
	
	WenchuangjiaohuanVO selectVO(@Param("ew") Wrapper<WenchuangjiaohuanEntity> wrapper);
	
	List<WenchuangjiaohuanView> selectListView(@Param("ew") Wrapper<WenchuangjiaohuanEntity> wrapper);

	List<WenchuangjiaohuanView> selectListView(Pagination page,@Param("ew") Wrapper<WenchuangjiaohuanEntity> wrapper);

	
	WenchuangjiaohuanView selectView(@Param("ew") Wrapper<WenchuangjiaohuanEntity> wrapper);
	

}
