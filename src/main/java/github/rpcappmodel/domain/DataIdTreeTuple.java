package github.rpcappmodel.domain;

import java.io.Serializable;

public class DataIdTreeTuple implements Serializable {
	private static final long serialVersionUID = 1L;

	private int dataType = 0;
	private int subDataType = 0;
	private long dataId = 0;

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public int getSubDataType() {
		return subDataType;
	}

	public void setSubDataType(int subDataType) {
		this.subDataType = subDataType;
	}

	public long getDataId() {
		return dataId;
	}

	public void setDataId(long dataId) {
		this.dataId = dataId;
	}

}
