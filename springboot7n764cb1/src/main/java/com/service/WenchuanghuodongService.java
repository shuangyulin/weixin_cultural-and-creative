package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WenchuanghuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WenchuanghuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WenchuanghuodongView;


/**
 * 文创活动
 *
 * @author 
 * @email 
 * @date 2025-03-01 09:55:51
 */
public interface WenchuanghuodongService extends IService<WenchuanghuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WenchuanghuodongVO> selectListVO(Wrapper<WenchuanghuodongEntity> wrapper);
   	
   	WenchuanghuodongVO selectVO(@Param("ew") Wrapper<WenchuanghuodongEntity> wrapper);
   	
   	List<WenchuanghuodongView> selectListView(Wrapper<WenchuanghuodongEntity> wrapper);
   	
   	WenchuanghuodongView selectView(@Param("ew") Wrapper<WenchuanghuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WenchuanghuodongEntity> wrapper);

   	

}

