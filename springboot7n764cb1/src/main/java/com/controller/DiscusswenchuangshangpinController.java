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

import com.entity.DiscusswenchuangshangpinEntity;
import com.entity.view.DiscusswenchuangshangpinView;

import com.service.DiscusswenchuangshangpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 文创商品评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-01 09:55:53
 */
@RestController
@RequestMapping("/discusswenchuangshangpin")
public class DiscusswenchuangshangpinController {
    @Autowired
    private DiscusswenchuangshangpinService discusswenchuangshangpinService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusswenchuangshangpinEntity discusswenchuangshangpin,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscusswenchuangshangpinEntity> ew = new EntityWrapper<DiscusswenchuangshangpinEntity>();


        //查询结果
		PageUtils page = discusswenchuangshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusswenchuangshangpin), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DiscusswenchuangshangpinEntity discusswenchuangshangpin, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscusswenchuangshangpinEntity> ew = new EntityWrapper<DiscusswenchuangshangpinEntity>();

        //查询结果
		PageUtils page = discusswenchuangshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusswenchuangshangpin), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusswenchuangshangpinEntity discusswenchuangshangpin){
       	EntityWrapper<DiscusswenchuangshangpinEntity> ew = new EntityWrapper<DiscusswenchuangshangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusswenchuangshangpin, "discusswenchuangshangpin")); 
        return R.ok().put("data", discusswenchuangshangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusswenchuangshangpinEntity discusswenchuangshangpin){
        EntityWrapper< DiscusswenchuangshangpinEntity> ew = new EntityWrapper< DiscusswenchuangshangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusswenchuangshangpin, "discusswenchuangshangpin")); 
		DiscusswenchuangshangpinView discusswenchuangshangpinView =  discusswenchuangshangpinService.selectView(ew);
		return R.ok("查询文创商品评论表成功").put("data", discusswenchuangshangpinView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusswenchuangshangpinEntity discusswenchuangshangpin = discusswenchuangshangpinService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discusswenchuangshangpin,deSens);
        return R.ok().put("data", discusswenchuangshangpin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusswenchuangshangpinEntity discusswenchuangshangpin = discusswenchuangshangpinService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discusswenchuangshangpin,deSens);
        return R.ok().put("data", discusswenchuangshangpin);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusswenchuangshangpinEntity discusswenchuangshangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusswenchuangshangpin);
        discusswenchuangshangpinService.insert(discusswenchuangshangpin);
        return R.ok().put("data",discusswenchuangshangpin.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusswenchuangshangpinEntity discusswenchuangshangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusswenchuangshangpin);
        discusswenchuangshangpinService.insert(discusswenchuangshangpin);
        return R.ok().put("data",discusswenchuangshangpin.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscusswenchuangshangpinEntity discusswenchuangshangpin = discusswenchuangshangpinService.selectOne(new EntityWrapper<DiscusswenchuangshangpinEntity>().eq("", username));
        return R.ok().put("data", discusswenchuangshangpin);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscusswenchuangshangpinEntity discusswenchuangshangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusswenchuangshangpin);
        //全部更新
        discusswenchuangshangpinService.updateById(discusswenchuangshangpin);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusswenchuangshangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscusswenchuangshangpinEntity discusswenchuangshangpin, HttpServletRequest request,String pre){
        EntityWrapper<DiscusswenchuangshangpinEntity> ew = new EntityWrapper<DiscusswenchuangshangpinEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");

		PageUtils page = discusswenchuangshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusswenchuangshangpin), params), params));
        return R.ok().put("data", page);
    }








}
