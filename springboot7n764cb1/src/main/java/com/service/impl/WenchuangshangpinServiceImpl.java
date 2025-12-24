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


import com.dao.WenchuangshangpinDao;
import com.entity.WenchuangshangpinEntity;
import com.service.WenchuangshangpinService;
import com.entity.vo.WenchuangshangpinVO;
import com.entity.view.WenchuangshangpinView;

@Service("wenchuangshangpinService")
public class WenchuangshangpinServiceImpl extends ServiceImpl<WenchuangshangpinDao, WenchuangshangpinEntity> implements WenchuangshangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WenchuangshangpinEntity> page = this.selectPage(
                new Query<WenchuangshangpinEntity>(params).getPage(),
                new EntityWrapper<WenchuangshangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WenchuangshangpinEntity> wrapper) {
		  Page<WenchuangshangpinView> page =new Query<WenchuangshangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<WenchuangshangpinVO> selectListVO(Wrapper<WenchuangshangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WenchuangshangpinVO selectVO(Wrapper<WenchuangshangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WenchuangshangpinView> selectListView(Wrapper<WenchuangshangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WenchuangshangpinView selectView(Wrapper<WenchuangshangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
