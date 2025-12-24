package com.entity.view;

import com.entity.JifenpaixingbangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 积分排行榜
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-01 09:55:51
 */
@TableName("jifenpaixingbang")
public class JifenpaixingbangView  extends JifenpaixingbangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JifenpaixingbangView(){
	}
 
 	public JifenpaixingbangView(JifenpaixingbangEntity jifenpaixingbangEntity){
 	try {
			BeanUtils.copyProperties(this, jifenpaixingbangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
