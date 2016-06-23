package mock.model;

import java.util.Date;

public class Protocol {
	private String ID;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	private String Pname;
	
	
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
	
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}

}
