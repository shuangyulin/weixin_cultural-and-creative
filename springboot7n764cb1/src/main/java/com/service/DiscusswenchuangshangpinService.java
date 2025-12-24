package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusswenchuangshangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusswenchuangshangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusswenchuangshangpinView;


/**
 * 文创商品评论表
 *
 * @author 
 * @email 
 * @date 2025-03-01 09:55:53
 */
public interface DiscusswenchuangshangpinService extends IService<DiscusswenchuangshangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusswenchuangshangpinVO> selectListVO(Wrapper<DiscusswenchuangshangpinEntity> wrapper);
   	
   	DiscusswenchuangshangpinVO selectVO(@Param("ew") Wrapper<DiscusswenchuangshangpinEntity> wrapper);
   	
   	List<DiscusswenchuangshangpinView> selectListView(Wrapper<DiscusswenchuangshangpinEntity> wrapper);
   	
   	DiscusswenchuangshangpinView selectView(@Param("ew") Wrapper<DiscusswenchuangshangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusswenchuangshangpinEntity> wrapper);

   	

}

