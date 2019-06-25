package site.chiyu.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/****
 * 评论类
 * @author HOME
 *	评论ID,评论内容，创建时间，回答id，用户id
 */
public class Comm implements Serializable{
	private String commId;
	private String commCon;
	private Timestamp ctime;
	private String answerId;
	private String memId;
	public String getCommId() {
		return commId;
	}
	public void setCommId(String commId) {
		this.commId = commId;
	}
	public String getCommCon() {
		return commCon;
	}
	public void setCommCon(String commCon) {
		this.commCon = commCon;
	}
	public Timestamp getCtime() {
		return ctime;
	}
	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}
	public String getAnswerId() {
		return answerId;
	}
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	
}
