package com.dao;

import com.entity.JifenpaixingbangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JifenpaixingbangVO;
import com.entity.view.JifenpaixingbangView;


/**
 * 积分排行榜
 * 
 * @author 
 * @email 
 * @date 2025-03-01 09:55:51
 */
public interface JifenpaixingbangDao extends BaseMapper<JifenpaixingbangEntity> {
	
	List<JifenpaixingbangVO> selectListVO(@Param("ew") Wrapper<JifenpaixingbangEntity> wrapper);
	
	JifenpaixingbangVO selectVO(@Param("ew") Wrapper<JifenpaixingbangEntity> wrapper);
	
	List<JifenpaixingbangView> selectListView(@Param("ew") Wrapper<JifenpaixingbangEntity> wrapper);

	List<JifenpaixingbangView> selectListView(Pagination page,@Param("ew") Wrapper<JifenpaixingbangEntity> wrapper);

	
	JifenpaixingbangView selectView(@Param("ew") Wrapper<JifenpaixingbangEntity> wrapper);
	

}
