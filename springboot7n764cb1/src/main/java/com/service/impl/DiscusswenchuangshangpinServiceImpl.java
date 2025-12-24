package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscusswenchuangshangpinDao;
import com.entity.DiscusswenchuangshangpinEntity;
import com.service.DiscusswenchuangshangpinService;
import com.entity.vo.DiscusswenchuangshangpinVO;
import com.entity.view.DiscusswenchuangshangpinView;

@Service("discusswenchuangshangpinService")
public class DiscusswenchuangshangpinServiceImpl extends ServiceImpl<DiscusswenchuangshangpinDao, DiscusswenchuangshangpinEntity> implements DiscusswenchuangshangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusswenchuangshangpinEntity> page = this.selectPage(
                new Query<DiscusswenchuangshangpinEntity>(params).getPage(),
                new EntityWrapper<DiscusswenchuangshangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusswenchuangshangpinEntity> wrapper) {
		  Page<DiscusswenchuangshangpinView> page =new Query<DiscusswenchuangshangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusswenchuangshangpinVO> selectListVO(Wrapper<DiscusswenchuangshangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusswenchuangshangpinVO selectVO(Wrapper<DiscusswenchuangshangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusswenchuangshangpinView> selectListView(Wrapper<DiscusswenchuangshangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusswenchuangshangpinView selectView(Wrapper<DiscusswenchuangshangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
