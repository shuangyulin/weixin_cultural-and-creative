package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 语音讲解
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-03-01 09:55:52
 */
@TableName("yuyinjiangjie")
public class YuyinjiangjieEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YuyinjiangjieEntity() {
		
	}
	
	public YuyinjiangjieEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 标题
	 */
					
	private String biaoti;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：标题
	 */
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	/**
	 * 获取：标题
	 */
	public String getBiaoti() {
		return biaoti;
	}
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
