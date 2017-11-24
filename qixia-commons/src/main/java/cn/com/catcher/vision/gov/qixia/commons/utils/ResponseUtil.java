package cn.com.catcher.vision.gov.qixia.commons.utils;

import cn.com.catcher.vision.gov.qixia.commons.constants.Constant;
import cn.com.catcher.vision.gov.qixia.commons.model.CommonResponse;
import net.sf.json.JSONObject;

public class ResponseUtil {
	/**
	 * 请求返回数据处理
	 * @param res
	 * @return
	 */
	public static String general(CommonResponse res){
		return JSONObject.fromObject(res).toString();
	}
	
	/**
	 * 成功请求
	 * @param data
	 * @return
	 */
	public static String success(Object data){
		CommonResponse res = new CommonResponse();
		res.setCode(Constant.RESCODE_SUCCESS);
		res.setData(data);
		return general(res);
	}
	
	public static String success(){
		CommonResponse res = new CommonResponse();
		res.setCode(Constant.RESCODE_SUCCESS);
		return general(res);
	}
	
	public static String success(String msg){
		CommonResponse res = new CommonResponse();
		res.setCode(Constant.RESCODE_SUCCESS_MSG);
		res.setMsg(msg);
		return general(res);
	}
	
	/**
	 * 请求抛出异常
	 * @param msg
	 * @return
	 */
	public static String exception(String msg){
		CommonResponse res = new CommonResponse();
		res.setCode(Constant.RESCODE_EXCEPTION);
		res.setMsg(msg);
		return general(res);
	}
	
	public static String unKonwException(){
		CommonResponse res = new CommonResponse();
		res.setCode(Constant.RESCODE_EXCEPTION);
		res.setMsg("请稍后再�?");
		return general(res);
	}
	
	

	/**
	 * 自定�?
	 * @param code
	 * @param msg
	 * @return
	 */
	public static String custom(Integer code, String msg){
		CommonResponse res = new CommonResponse();
		res.setCode(code);
		res.setMsg(msg);
		return general(res);
	}
	
	
	/**
	 * 用户未登�?
	 * @return
	 */
	public static String noLogin() {
		CommonResponse res = new CommonResponse();
		res.setCode(Constant.RESCODE_NOLOGIN);
		res.setMsg("用户未登�?");
		
		return general(res);
	}
	
	/**
	 * 登录过期
	 * @return
	 */
	public static String loginExpire() {
		CommonResponse res = new CommonResponse();
		res.setCode(Constant.RESCODE_LOGINEXPIRE);
		res.setMsg("登录过期");
		return general(res);
	}
	
	
	/**
	 * 无操作权�?
	 * @return
	 */
	public static String noAuth() {
		CommonResponse res = new CommonResponse();
		res.setCode(Constant.RESCODE_NOAUTH);
		res.setMsg("拒绝授权");
		return general(res);
	}
}
