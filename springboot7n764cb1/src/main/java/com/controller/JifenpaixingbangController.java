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

import com.entity.JifenpaixingbangEntity;
import com.entity.view.JifenpaixingbangView;

import com.service.JifenpaixingbangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 积分排行榜
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-01 09:55:51
 */
@RestController
@RequestMapping("/jifenpaixingbang")
public class JifenpaixingbangController {
    @Autowired
    private JifenpaixingbangService jifenpaixingbangService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JifenpaixingbangEntity jifenpaixingbang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jifenpaixingbang.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<JifenpaixingbangEntity> ew = new EntityWrapper<JifenpaixingbangEntity>();


        //查询结果
		PageUtils page = jifenpaixingbangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jifenpaixingbang), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JifenpaixingbangEntity jifenpaixingbang, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JifenpaixingbangEntity> ew = new EntityWrapper<JifenpaixingbangEntity>();

        //查询结果
		PageUtils page = jifenpaixingbangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jifenpaixingbang), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JifenpaixingbangEntity jifenpaixingbang){
       	EntityWrapper<JifenpaixingbangEntity> ew = new EntityWrapper<JifenpaixingbangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jifenpaixingbang, "jifenpaixingbang")); 
        return R.ok().put("data", jifenpaixingbangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JifenpaixingbangEntity jifenpaixingbang){
        EntityWrapper< JifenpaixingbangEntity> ew = new EntityWrapper< JifenpaixingbangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jifenpaixingbang, "jifenpaixingbang")); 
		JifenpaixingbangView jifenpaixingbangView =  jifenpaixingbangService.selectView(ew);
		return R.ok("查询积分排行榜成功").put("data", jifenpaixingbangView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JifenpaixingbangEntity jifenpaixingbang = jifenpaixingbangService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jifenpaixingbang,deSens);
        return R.ok().put("data", jifenpaixingbang);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JifenpaixingbangEntity jifenpaixingbang = jifenpaixingbangService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jifenpaixingbang,deSens);
        return R.ok().put("data", jifenpaixingbang);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        JifenpaixingbangEntity jifenpaixingbang = jifenpaixingbangService.selectById(id);
        if(type.equals("1")) {
        	jifenpaixingbang.setThumbsupnum(jifenpaixingbang.getThumbsupnum()+1);
        } else {
        	jifenpaixingbang.setCrazilynum(jifenpaixingbang.getCrazilynum()+1);
        }
        jifenpaixingbangService.updateById(jifenpaixingbang);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JifenpaixingbangEntity jifenpaixingbang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jifenpaixingbang);
        jifenpaixingbangService.insert(jifenpaixingbang);
        return R.ok().put("data",jifenpaixingbang.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JifenpaixingbangEntity jifenpaixingbang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jifenpaixingbang);
        jifenpaixingbangService.insert(jifenpaixingbang);
        return R.ok().put("data",jifenpaixingbang.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JifenpaixingbangEntity jifenpaixingbang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jifenpaixingbang);
        //全部更新
        jifenpaixingbangService.updateById(jifenpaixingbang);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jifenpaixingbangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
