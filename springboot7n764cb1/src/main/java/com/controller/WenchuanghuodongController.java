package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.WenchuanghuodongEntity;
import com.entity.view.WenchuanghuodongView;

import com.service.WenchuanghuodongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 文创活动
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-01 09:55:51
 */
@RestController
@RequestMapping("/wenchuanghuodong")
public class WenchuanghuodongController {
    @Autowired
    private WenchuanghuodongService wenchuanghuodongService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WenchuanghuodongEntity wenchuanghuodong,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<WenchuanghuodongEntity> ew = new EntityWrapper<WenchuanghuodongEntity>();


        //查询结果
		PageUtils page = wenchuanghuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenchuanghuodong), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WenchuanghuodongEntity wenchuanghuodong, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<WenchuanghuodongEntity> ew = new EntityWrapper<WenchuanghuodongEntity>();

        //查询结果
		PageUtils page = wenchuanghuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenchuanghuodong), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WenchuanghuodongEntity wenchuanghuodong){
       	EntityWrapper<WenchuanghuodongEntity> ew = new EntityWrapper<WenchuanghuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wenchuanghuodong, "wenchuanghuodong")); 
        return R.ok().put("data", wenchuanghuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WenchuanghuodongEntity wenchuanghuodong){
        EntityWrapper< WenchuanghuodongEntity> ew = new EntityWrapper< WenchuanghuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wenchuanghuodong, "wenchuanghuodong")); 
		WenchuanghuodongView wenchuanghuodongView =  wenchuanghuodongService.selectView(ew);
		return R.ok("查询文创活动成功").put("data", wenchuanghuodongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WenchuanghuodongEntity wenchuanghuodong = wenchuanghuodongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(wenchuanghuodong,deSens);
        return R.ok().put("data", wenchuanghuodong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WenchuanghuodongEntity wenchuanghuodong = wenchuanghuodongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(wenchuanghuodong,deSens);
        return R.ok().put("data", wenchuanghuodong);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WenchuanghuodongEntity wenchuanghuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wenchuanghuodong);
        wenchuanghuodongService.insert(wenchuanghuodong);
        return R.ok().put("data",wenchuanghuodong.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WenchuanghuodongEntity wenchuanghuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wenchuanghuodong);
        wenchuanghuodongService.insert(wenchuanghuodong);
        return R.ok().put("data",wenchuanghuodong.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WenchuanghuodongEntity wenchuanghuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wenchuanghuodong);
        //全部更新
        wenchuanghuodongService.updateById(wenchuanghuodong);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wenchuanghuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
