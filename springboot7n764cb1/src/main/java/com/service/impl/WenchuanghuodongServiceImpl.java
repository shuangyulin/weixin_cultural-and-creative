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


import com.dao.WenchuanghuodongDao;
import com.entity.WenchuanghuodongEntity;
import com.service.WenchuanghuodongService;
import com.entity.vo.WenchuanghuodongVO;
import com.entity.view.WenchuanghuodongView;

@Service("wenchuanghuodongService")
public class WenchuanghuodongServiceImpl extends ServiceImpl<WenchuanghuodongDao, WenchuanghuodongEntity> implements WenchuanghuodongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WenchuanghuodongEntity> page = this.selectPage(
                new Query<WenchuanghuodongEntity>(params).getPage(),
                new EntityWrapper<WenchuanghuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WenchuanghuodongEntity> wrapper) {
		  Page<WenchuanghuodongView> page =new Query<WenchuanghuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<WenchuanghuodongVO> selectListVO(Wrapper<WenchuanghuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WenchuanghuodongVO selectVO(Wrapper<WenchuanghuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WenchuanghuodongView> selectListView(Wrapper<WenchuanghuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WenchuanghuodongView selectView(Wrapper<WenchuanghuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
