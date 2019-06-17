package site.chiyu.bean;

import java.sql.Timestamp;

public class Answer {
	/***
	 * 回答类
	 * 回答标识id,赞数，评论，评论数，创建时间，用户id，主题id
	 */
	private String answerId;
	private String ansCon;
	private int zan;
	private String com;
	private int comCount;
	private Timestamp ctime;
	private String memId;
	private String topId;
	
	public String getAnswerId() {
		return answerId;
	}
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
	
	
	public String getAnsCon() {
		return ansCon;
	}
	public void setAnsCon(String ansCon) {
		this.ansCon = ansCon;
	}
	public int getZan() {
		return zan;
	}
	public void setZan(int zan) {
		this.zan = zan;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public int getComCount() {
		return comCount;
	}
	public void setComCount(int comCount) {
		this.comCount = comCount;
	}
	public Timestamp getCtime() {
		return ctime;
	}
	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getTopId() {
		return topId;
	}
	public void setTopId(String topId) {
		this.topId = topId;
	}
	
	
}
