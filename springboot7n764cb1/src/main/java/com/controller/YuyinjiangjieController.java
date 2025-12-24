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

import com.entity.YuyinjiangjieEntity;
import com.entity.view.YuyinjiangjieView;

import com.service.YuyinjiangjieService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 语音讲解
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-01 09:55:52
 */
@RestController
@RequestMapping("/yuyinjiangjie")
public class YuyinjiangjieController {
    @Autowired
    private YuyinjiangjieService yuyinjiangjieService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuyinjiangjieEntity yuyinjiangjie,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YuyinjiangjieEntity> ew = new EntityWrapper<YuyinjiangjieEntity>();


        //查询结果
		PageUtils page = yuyinjiangjieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyinjiangjie), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YuyinjiangjieEntity yuyinjiangjie, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YuyinjiangjieEntity> ew = new EntityWrapper<YuyinjiangjieEntity>();

        //查询结果
		PageUtils page = yuyinjiangjieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyinjiangjie), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuyinjiangjieEntity yuyinjiangjie){
       	EntityWrapper<YuyinjiangjieEntity> ew = new EntityWrapper<YuyinjiangjieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuyinjiangjie, "yuyinjiangjie")); 
        return R.ok().put("data", yuyinjiangjieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuyinjiangjieEntity yuyinjiangjie){
        EntityWrapper< YuyinjiangjieEntity> ew = new EntityWrapper< YuyinjiangjieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuyinjiangjie, "yuyinjiangjie")); 
		YuyinjiangjieView yuyinjiangjieView =  yuyinjiangjieService.selectView(ew);
		return R.ok("查询语音讲解成功").put("data", yuyinjiangjieView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuyinjiangjieEntity yuyinjiangjie = yuyinjiangjieService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yuyinjiangjie,deSens);
        return R.ok().put("data", yuyinjiangjie);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuyinjiangjieEntity yuyinjiangjie = yuyinjiangjieService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yuyinjiangjie,deSens);
        return R.ok().put("data", yuyinjiangjie);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuyinjiangjieEntity yuyinjiangjie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyinjiangjie);
        yuyinjiangjieService.insert(yuyinjiangjie);
        return R.ok().put("data",yuyinjiangjie.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuyinjiangjieEntity yuyinjiangjie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyinjiangjie);
        yuyinjiangjieService.insert(yuyinjiangjie);
        return R.ok().put("data",yuyinjiangjie.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuyinjiangjieEntity yuyinjiangjie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyinjiangjie);
        //全部更新
        yuyinjiangjieService.updateById(yuyinjiangjie);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuyinjiangjieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
