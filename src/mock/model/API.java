package mock.model;

import java.util.Date;

public class API {
	private String ID;
	private String APIName;
	
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAPIName() {
		return APIName;
	}
	public void setAPIName(String aPIName) {
		APIName = aPIName;
	}
	public String getMSID() {
		return MSID;
	}
	public void setMSID(String mSID) {
		MSID = mSID;
	}


	private String MSID;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}


	private Date CreatedTime;
	public Date getCreatedTime() {
		return CreatedTime;
	}
	public void setCreatedTime(Date createdTime) {
		CreatedTime = createdTime;
	}
	public Date getLastModify() {
		return LastModify;
	}
	public void setLastModify(Date lastModify) {
		LastModify = lastModify;
	}
	public char getEnable() {
		return Enable;
	}
	public void setEnable(char enable) {
		Enable = enable;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	private Date LastModify;
	private char Enable;
	private String Remark;

}
