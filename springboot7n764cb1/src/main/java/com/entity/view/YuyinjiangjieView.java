package com.entity.view;

import com.entity.YuyinjiangjieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 语音讲解
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-01 09:55:52
 */
@TableName("yuyinjiangjie")
public class YuyinjiangjieView  extends YuyinjiangjieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuyinjiangjieView(){
	}
 
 	public YuyinjiangjieView(YuyinjiangjieEntity yuyinjiangjieEntity){
 	try {
			BeanUtils.copyProperties(this, yuyinjiangjieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
