package github.rpcappmodel.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class PersistDO implements Serializable {
	private static final long serialVersionUID = 1L;

	protected long id;
	private long optionBit;
	private JSONObject features = new JSONObject();
	private LocalDateTime createTime;
	private LocalDateTime updateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOptionBit() {
		return optionBit;
	}

	public void setOptionBit(long flagBit) {
		this.optionBit = flagBit;
	}

	public void setFeatures(String features) {
		this.features = JSONObject.parseObject(features, Feature.AllowISO8601DateFormat);
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public String getFeatures() {
		return JSON.toJSONString(features, SerializerFeature.UseISO8601DateFormat);
	}

	public <T> T getFeature(String columnName, Class<T> clazz) {
		return features.getObject(columnName, clazz);
	}

	public String getFeature(String columnName) {
		return features.getString(columnName);
	}

	public void setupFeature(String columnName, Object value) {
		features.put(columnName, value);
	}

	public void removeFeature(String columnName) {
		features.remove(columnName);
	}
}
