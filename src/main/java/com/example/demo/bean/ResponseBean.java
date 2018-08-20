package com.example.demo.bean;

import java.io.Serializable;

import com.example.demo.util.IConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Data;

/**
 * @ClassName:  ResponseBean
 * @Description: 通用的返回数据结构定义类
 * @author:  qingyun.zhao
 * @date:    2017年9月14日 下午1:40:24
 * @version: V1.0
 */
@Data
@ApiModel("请求响应信息")
@ApiResponses(value = { @ApiResponse(code = 200, message = "请求正常响应成功") })
public class ResponseBean<T> implements Serializable {

	/**
	 * @Fields serialVersionUID : serialVersionUID
	 */
	private static final long serialVersionUID = -103263966756520602L;
	/**
	 * @Fields SUCCESS : 正常返回的常量
	 */
	public static final int SUCCESS = IConstant.NUM_0;
	/**
	 * @Fields FAIL : 失败返回的常量
	 */
	public static final int FAIL = IConstant.NUM_1;
	/**
	 * @Fields NO_PERMISSION : 没有权限返回的常量
	 */
	public static final int NO_PERMISSION = IConstant.NUM_2;
	/**
	 * @Fields message : 返回的message定义
	 */
	@ApiModelProperty("请求响应描述信息")
	private String message = IConstant.STR_SUCCESS;
	/**
	 * @Fields msgCode : 返回的msgCode定义
	 */
	@ApiModelProperty("请求响应标识")
	private int msgCode = SUCCESS;
	/**
	 * @Fields data : 返回的真实数据对象
	 */
	@ApiModelProperty("请求响应返回的数据")
	private T data;
	
	/**
	 * <p>@Title:  ResponseBean</p>
	 * <p>@Description: 默认构造函数</p>
	 */
	public ResponseBean() {
		super();
	}
	
	/**
	 * <p>@Title:  ResponseBean</p>
	 * <p>@Description: 构造函数</p>
	 * @param: data 需要返回的数据对象
	 */
	public ResponseBean(T data) {
		super();
		this.data = data;
	}
	
	/**
	 * <p>@Title:  ResponseBean</p>
	 * <p>@Description: 构造函数</p>
	 * @param: e Throwable
	 */
	public ResponseBean(Throwable e) {
		super();
		this.message = e.toString();
		this.msgCode = FAIL;
	}
	
	/**
	 * <p>@Title:  ResponseBean</p>
	 * <p>@Description: 构造函数</p>
	 * @param: e Throwable
	 * @param: message 错误提示信息
	 */
	public ResponseBean(Throwable e, String message) {
		super();
		this.message = message;
		this.msgCode = FAIL;
	}
}