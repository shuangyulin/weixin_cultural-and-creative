package com.entity.vo;

import com.entity.YuyinjiangjieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 语音讲解
 * @author 
 * @email 
 * @date 2025-03-01 09:55:52
 */
public class YuyinjiangjieVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 语音讲解
	 */
	
	private String yuyinjiangjie;
		
	/**
	 * 来源
	 */
	
	private String laiyuan;
		
	/**
	 * 详情
	 */
	
	private String xiangqing;
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：语音讲解
	 */
	 
	public void setYuyinjiangjie(String yuyinjiangjie) {
		this.yuyinjiangjie = yuyinjiangjie;
	}
	
	/**
	 * 获取：语音讲解
	 */
	public String getYuyinjiangjie() {
		return yuyinjiangjie;
	}
				
	
	/**
	 * 设置：来源
	 */
	 
	public void setLaiyuan(String laiyuan) {
		this.laiyuan = laiyuan;
	}
	
	/**
	 * 获取：来源
	 */
	public String getLaiyuan() {
		return laiyuan;
	}
				
	
	/**
	 * 设置：详情
	 */
	 
	public void setXiangqing(String xiangqing) {
		this.xiangqing = xiangqing;
	}
	
	/**
	 * 获取：详情
	 */
	public String getXiangqing() {
		return xiangqing;
	}
			
}
