package cn.com.catcher.vision.gov.qixia.commons.model;

public class CommonResponse {
	private Integer code;	//返回�?
	private String msg;		//返回提示信息
	private Object data;	//返回数据
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
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
}
