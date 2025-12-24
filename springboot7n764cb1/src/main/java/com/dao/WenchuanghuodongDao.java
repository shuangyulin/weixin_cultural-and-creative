package com.dao;

import com.entity.WenchuanghuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WenchuanghuodongVO;
import com.entity.view.WenchuanghuodongView;


/**
 * 文创活动
 * 
 * @author 
 * @email 
 * @date 2025-03-01 09:55:51
 */
public interface WenchuanghuodongDao extends BaseMapper<WenchuanghuodongEntity> {
	
	List<WenchuanghuodongVO> selectListVO(@Param("ew") Wrapper<WenchuanghuodongEntity> wrapper);
	
	WenchuanghuodongVO selectVO(@Param("ew") Wrapper<WenchuanghuodongEntity> wrapper);
	
	List<WenchuanghuodongView> selectListView(@Param("ew") Wrapper<WenchuanghuodongEntity> wrapper);

	List<WenchuanghuodongView> selectListView(Pagination page,@Param("ew") Wrapper<WenchuanghuodongEntity> wrapper);

	
	WenchuanghuodongView selectView(@Param("ew") Wrapper<WenchuanghuodongEntity> wrapper);
	

}
