package com.blogforum.common.tools;

import java.util.List;

import com.blogforum.common.enums.BizError;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 博记系统自定义响应结构
 * 
 * @author wwd
 */
public class blogforumResult {

	// 定义jackson对象
	private static final ObjectMapper	MAPPER	= new ObjectMapper();

	// 响应业务状态
	private String						status;

	// 响应消息
	private String						msg;

	// 响应中的数据
	private Object						data;

	// 状态
	private String						success;

	public static blogforumResult build(String status, String msg, String success, Object data) {
		return new blogforumResult(status, msg, success, data);
	}

	public static blogforumResult ok(Object data) {
		return new blogforumResult(data);
	}

	@JsonFormat
	public static blogforumResult ok() {
		return new blogforumResult(null);
	}

	public blogforumResult() {

	}
	
	@JsonFormat
	public static blogforumResult build(BizError bizError, String success) {
		String status = bizError.getStatus();
		String msg = bizError.getMsg();
		return new blogforumResult(status, msg, success, null);
	}

	@JsonFormat
	public static blogforumResult build(String status, String msg, String success) {
		return new blogforumResult(status, msg, success, null);
	}

	public blogforumResult(String status, String msg, String success, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
		this.success = success;
	}

	public blogforumResult(Object data) {
		this.status = "200";
		this.msg = "OK";
		this.data = data;
	}

	// public Boolean isOK() {
	// return this.status == 200;
	// }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 将json结果集转化为blogforumResult对象
	 * 
	 * @param jsonData
	 *            json数据
	 * @param clazz
	 *            TaotaoResult中的object类型
	 * @return
	 */
	public static blogforumResult formatToPojo(String jsonData, Class<?> clazz) {
		try {
			if (clazz == null) {
				return MAPPER.readValue(jsonData, blogforumResult.class);
			}
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (clazz != null) {
				if (data.isObject()) {
					obj = MAPPER.readValue(data.traverse(), clazz);
				} else if (data.isTextual()) {
					obj = MAPPER.readValue(data.asText(), clazz);
				}
			}
			return build(jsonNode.get("status").asText(), jsonNode.get("msg").asText(),
								jsonNode.get("success").asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 没有object对象的转化
	 * 
	 * @param json
	 * @return
	 */
	public static blogforumResult format(String json) {
		try {
			return MAPPER.readValue(json, blogforumResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Object是集合转化
	 * 
	 * @param jsonData
	 *            json数据
	 * @param clazz
	 *            集合中的类型
	 * @return
	 */
	public static blogforumResult formatToList(String jsonData, Class<?> clazz) {
		try {
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (data.isArray() && data.size() > 0) {
				obj = MAPPER.readValue(data.traverse(),
									MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
			}
			return build(jsonNode.get("status").asText(), jsonNode.get("msg").asText(),
								jsonNode.get("success").asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}

	public String isSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

}
