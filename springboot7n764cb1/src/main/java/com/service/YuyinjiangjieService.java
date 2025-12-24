package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuyinjiangjieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuyinjiangjieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuyinjiangjieView;


/**
 * 语音讲解
 *
 * @author 
 * @email 
 * @date 2025-03-01 09:55:52
 */
public interface YuyinjiangjieService extends IService<YuyinjiangjieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyinjiangjieVO> selectListVO(Wrapper<YuyinjiangjieEntity> wrapper);
   	
   	YuyinjiangjieVO selectVO(@Param("ew") Wrapper<YuyinjiangjieEntity> wrapper);
   	
   	List<YuyinjiangjieView> selectListView(Wrapper<YuyinjiangjieEntity> wrapper);
   	
   	YuyinjiangjieView selectView(@Param("ew") Wrapper<YuyinjiangjieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyinjiangjieEntity> wrapper);

   	

}

