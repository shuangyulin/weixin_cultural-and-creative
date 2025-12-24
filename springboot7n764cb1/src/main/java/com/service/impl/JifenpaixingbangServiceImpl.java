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


import com.dao.JifenpaixingbangDao;
import com.entity.JifenpaixingbangEntity;
import com.service.JifenpaixingbangService;
import com.entity.vo.JifenpaixingbangVO;
import com.entity.view.JifenpaixingbangView;

@Service("jifenpaixingbangService")
public class JifenpaixingbangServiceImpl extends ServiceImpl<JifenpaixingbangDao, JifenpaixingbangEntity> implements JifenpaixingbangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JifenpaixingbangEntity> page = this.selectPage(
                new Query<JifenpaixingbangEntity>(params).getPage(),
                new EntityWrapper<JifenpaixingbangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JifenpaixingbangEntity> wrapper) {
		  Page<JifenpaixingbangView> page =new Query<JifenpaixingbangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JifenpaixingbangVO> selectListVO(Wrapper<JifenpaixingbangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JifenpaixingbangVO selectVO(Wrapper<JifenpaixingbangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JifenpaixingbangView> selectListView(Wrapper<JifenpaixingbangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JifenpaixingbangView selectView(Wrapper<JifenpaixingbangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
