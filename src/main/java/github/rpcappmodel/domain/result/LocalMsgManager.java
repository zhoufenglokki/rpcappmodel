package github.rpcappmodel.domain.result;

import github.rpcappmodel.constant.UnknownErrorCodeConstant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 本地化消息Bean, 通过属性文件进行异常消息的本地化 
 * 本地化时消息时，请在自己app中增加/appModelWarConf/localWarMessage.properties属性文件
 * ，并将本地化信息配置进去，本地化信息将会覆盖掉默认提示信息
 */
public class LocalMsgManager {
	private final Logger log = LoggerFactory.getLogger(getClass());

	public void init() {
		loadPropertiesToMap("/appModelLocalCommonJarConf/localMessage.properties");

		// war中自定义文案的优先级比 common jar 中高，体现在同key时，war中的后put，覆盖前面的
		loadPropertiesToMap("/appModelWarConf/localWarMessage.properties");
	}

	private void loadPropertiesToMap(String fileClassPath) {
		InputStream in = getClass().getResourceAsStream(fileClassPath);
		if(in == null)return;
		Properties properties = new Properties();
		try {
			properties.load(in);
			log.info("{msg:'load localMsg file successful', filePath:'{}'}", fileClassPath);
			
			// 放这里能排掉 load() 失败的未知不良影响，也能包在catch (Exception)中
			for(Entry<Object, Object> entry : properties.entrySet()){
				String value = (String) entry.getValue();
				if (StringUtils.isNotBlank(value)) {
					UnknownErrorCodeConstant.putMsg((String)entry.getKey(), value);
				}
			}

		} catch (Exception e) {
			log.error("{msg:'load localMsg file exception', filePath:'" + fileClassPath +  "'}", e);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				log.warn("{msg:'InputStream.close() exception'}", e);
			}
		}
	}
}
