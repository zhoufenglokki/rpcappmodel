package github.rpcappmodel.constant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author zhoufeng
 * 
 */
public class UnknownErrorCodeConstant {

	public final static String exceptionCanRetry = "exceptionCanRetry";
	public final static String exceptionRetryAfterBizCheck = "exceptionRetryAfterBizCheck";
	public final static String exceptionNeedTechCheck = "exceptionNeedTechCheck";

	private final static Map<String, String> errorMap = new ConcurrentHashMap<String, String>();

	static {
		errorMap.put(exceptionCanRetry, "遇到意料之外错误，如未达到操作要求，可再重试");
		errorMap.put(exceptionRetryAfterBizCheck, "遇到意料之外错误，请检查一下业务数据，没大问题可再重试");
		errorMap.put(exceptionNeedTechCheck, "遇到错误，请打开详细消息复制/截屏后告知客服检查");// 客服意思即是客服和开发人员
	}
	
	public static void putMsg(String errorCode, String msg) {
		errorMap.put(errorCode, msg);
	}


	public static String getMsg(String errorCode) {
		String errMsg = errorMap.get(errorCode);
		return errMsg;
	}

}
