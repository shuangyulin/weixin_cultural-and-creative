package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WenchuangshangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WenchuangshangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WenchuangshangpinView;


/**
 * 文创商品
 *
 * @author 
 * @email 
 * @date 2025-03-01 09:55:51
 */
public interface WenchuangshangpinService extends IService<WenchuangshangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WenchuangshangpinVO> selectListVO(Wrapper<WenchuangshangpinEntity> wrapper);
   	
   	WenchuangshangpinVO selectVO(@Param("ew") Wrapper<WenchuangshangpinEntity> wrapper);
   	
   	List<WenchuangshangpinView> selectListView(Wrapper<WenchuangshangpinEntity> wrapper);
   	
   	WenchuangshangpinView selectView(@Param("ew") Wrapper<WenchuangshangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WenchuangshangpinEntity> wrapper);

   	

}

