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


import com.dao.WenchuangjiaohuanDao;
import com.entity.WenchuangjiaohuanEntity;
import com.service.WenchuangjiaohuanService;
import com.entity.vo.WenchuangjiaohuanVO;
import com.entity.view.WenchuangjiaohuanView;

@Service("wenchuangjiaohuanService")
public class WenchuangjiaohuanServiceImpl extends ServiceImpl<WenchuangjiaohuanDao, WenchuangjiaohuanEntity> implements WenchuangjiaohuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WenchuangjiaohuanEntity> page = this.selectPage(
                new Query<WenchuangjiaohuanEntity>(params).getPage(),
                new EntityWrapper<WenchuangjiaohuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WenchuangjiaohuanEntity> wrapper) {
		  Page<WenchuangjiaohuanView> page =new Query<WenchuangjiaohuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<WenchuangjiaohuanVO> selectListVO(Wrapper<WenchuangjiaohuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WenchuangjiaohuanVO selectVO(Wrapper<WenchuangjiaohuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WenchuangjiaohuanView> selectListView(Wrapper<WenchuangjiaohuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WenchuangjiaohuanView selectView(Wrapper<WenchuangjiaohuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
