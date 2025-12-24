package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JifenpaixingbangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JifenpaixingbangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JifenpaixingbangView;


/**
 * 积分排行榜
 *
 * @author 
 * @email 
 * @date 2025-03-01 09:55:51
 */
public interface JifenpaixingbangService extends IService<JifenpaixingbangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JifenpaixingbangVO> selectListVO(Wrapper<JifenpaixingbangEntity> wrapper);
   	
   	JifenpaixingbangVO selectVO(@Param("ew") Wrapper<JifenpaixingbangEntity> wrapper);
   	
   	List<JifenpaixingbangView> selectListView(Wrapper<JifenpaixingbangEntity> wrapper);
   	
   	JifenpaixingbangView selectView(@Param("ew") Wrapper<JifenpaixingbangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JifenpaixingbangEntity> wrapper);

   	

}

