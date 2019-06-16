package site.chiyu.bean;

import java.sql.Timestamp;

public class Topic {
	/***
	 * 话题类
	 * 话题id,创建时间，修改时间，用户id
	 */
	private String topId;
	private Timestamp ctime;
	private Timestamp mtime;
	private String memId;
	
	public String getTopId() {
		return topId;
	}
	public void setTopId(String topId) {
		this.topId = topId;
	}
	public Timestamp getCtime() {
		return ctime;
	}
	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}
	public Timestamp getMtime() {
		return mtime;
	}
	public void setMtime(Timestamp mtime) {
		this.mtime = mtime;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	

}
