package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WenchuangjiaohuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WenchuangjiaohuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WenchuangjiaohuanView;


/**
 * 文创交换
 *
 * @author 
 * @email 
 * @date 2025-03-01 09:55:52
 */
public interface WenchuangjiaohuanService extends IService<WenchuangjiaohuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WenchuangjiaohuanVO> selectListVO(Wrapper<WenchuangjiaohuanEntity> wrapper);
   	
   	WenchuangjiaohuanVO selectVO(@Param("ew") Wrapper<WenchuangjiaohuanEntity> wrapper);
   	
   	List<WenchuangjiaohuanView> selectListView(Wrapper<WenchuangjiaohuanEntity> wrapper);
   	
   	WenchuangjiaohuanView selectView(@Param("ew") Wrapper<WenchuangjiaohuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WenchuangjiaohuanEntity> wrapper);

   	

}

