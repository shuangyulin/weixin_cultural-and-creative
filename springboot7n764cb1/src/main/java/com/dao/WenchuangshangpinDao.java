package com.dao;

import com.entity.WenchuangshangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WenchuangshangpinVO;
import com.entity.view.WenchuangshangpinView;


/**
 * 文创商品
 * 
 * @author 
 * @email 
 * @date 2025-03-01 09:55:51
 */
public interface WenchuangshangpinDao extends BaseMapper<WenchuangshangpinEntity> {
	
	List<WenchuangshangpinVO> selectListVO(@Param("ew") Wrapper<WenchuangshangpinEntity> wrapper);
	
	WenchuangshangpinVO selectVO(@Param("ew") Wrapper<WenchuangshangpinEntity> wrapper);
	
	List<WenchuangshangpinView> selectListView(@Param("ew") Wrapper<WenchuangshangpinEntity> wrapper);

	List<WenchuangshangpinView> selectListView(Pagination page,@Param("ew") Wrapper<WenchuangshangpinEntity> wrapper);

	
	WenchuangshangpinView selectView(@Param("ew") Wrapper<WenchuangshangpinEntity> wrapper);
	

}
