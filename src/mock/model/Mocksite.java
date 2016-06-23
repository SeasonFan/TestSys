package mock.model;

import java.util.Date;

public class Mocksite {
	
	private String ID;
	private String SiteName;
	private String PID;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getSiteName() {
		return SiteName;
	}
	public void setSiteName(String siteName) {
		SiteName = siteName;
	}
	public String getPID() {
		return PID;
	}
	public void setPID(String pID) {
		PID = pID;
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
