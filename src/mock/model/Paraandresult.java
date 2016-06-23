package mock.model;

import java.util.Date;

public class Paraandresult {
	private String ID;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPara() {
		return Para;
	}
	public void setPara(String para) {
		Para = para;
	}
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	public String getApiID() {
		return ApiID;
	}
	public void setApiID(String apiID) {
		ApiID = apiID;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	private String Para;
	private String Result;
	
	private String ApiID;
	private String IP;
	

	
	
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
	
	
	
	private String Callbackurl;
	public String getCallbackurl() {
		return Callbackurl;
	}
	public void setCallbackurl(String callbackurl) {
		Callbackurl = callbackurl;
	}
	private char IsCallback;
	public char getIsCallback() {
		return IsCallback;
	}
	public void setIsCallback(char isCallback) {
		IsCallback = isCallback;
	}
	private String CallbackHost;
	public String getCallbackHost() {
		return CallbackHost;
	}
	public void setCallbackHost(String callbackHost) {
		CallbackHost = callbackHost;
	}
	private int CallbackNums;
	public int getCallbackNums() {
		return CallbackNums;
	}
	public void setCallbackNums(int callbackNums) {
		CallbackNums = callbackNums;
	}
	private int CallbackDelayTimes;
	public int getCallbackDelayTimes() {
		return CallbackDelayTimes;
	}
	public void setCallbackDelayTimes(int callbackDelayTimes) {
		CallbackDelayTimes = callbackDelayTimes;
	}
	
	
	private int CallbackRequestType;
	public int getCallbackRequestType() {
		return CallbackRequestType;
	}
	public void setCallbackRequestType(int callbackRequestType) {
		CallbackRequestType = callbackRequestType;
	}

	
}
