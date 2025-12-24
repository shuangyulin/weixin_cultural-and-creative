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


import com.dao.YuyinjiangjieDao;
import com.entity.YuyinjiangjieEntity;
import com.service.YuyinjiangjieService;
import com.entity.vo.YuyinjiangjieVO;
import com.entity.view.YuyinjiangjieView;

@Service("yuyinjiangjieService")
public class YuyinjiangjieServiceImpl extends ServiceImpl<YuyinjiangjieDao, YuyinjiangjieEntity> implements YuyinjiangjieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyinjiangjieEntity> page = this.selectPage(
                new Query<YuyinjiangjieEntity>(params).getPage(),
                new EntityWrapper<YuyinjiangjieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyinjiangjieEntity> wrapper) {
		  Page<YuyinjiangjieView> page =new Query<YuyinjiangjieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YuyinjiangjieVO> selectListVO(Wrapper<YuyinjiangjieEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuyinjiangjieVO selectVO(Wrapper<YuyinjiangjieEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuyinjiangjieView> selectListView(Wrapper<YuyinjiangjieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyinjiangjieView selectView(Wrapper<YuyinjiangjieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
