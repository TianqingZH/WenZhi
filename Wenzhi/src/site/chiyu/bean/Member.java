package site.chiyu.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Member implements Serializable{
	/***
	 * 用户实体类
	 * 用户标识id,密码，昵称，性别，头像，签名，创建时间
	 */
	private String memId;
	private String pass;
	private String nickname;
	private String sex;
	private String tx;
	private String sig;
	private Timestamp mctime;
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTx() {
		return tx;
	}
	public void setTx(String tx) {
		this.tx = tx;
	}
	public String getSig() {
		return sig;
	}
	public void setSig(String sig) {
		this.sig = sig;
	}
	public Timestamp getMctime() {
		return mctime;
	}
	public void setMctime(Timestamp mctime) {
		this.mctime = mctime;
	}
	
	
	
}
