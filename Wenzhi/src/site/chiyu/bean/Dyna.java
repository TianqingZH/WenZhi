package site.chiyu.bean;

import java.sql.Timestamp;

/***
 * id，动态id，用户id，创建时间，otherId,flag
 * @author HOME
 *
 */
public class Dyna {
	private String dynaId;
	private String memId;
	private Timestamp ctime;
	private String otherId;
	private String flag;
	public String getDynaId() {
		return dynaId;
	}
	public void setDynaId(String dynaId) {
		this.dynaId = dynaId;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public Timestamp getCtime() {
		return ctime;
	}
	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}
	public String getotherId() {
		return otherId;
	}
	public void setotherId(String otherId) {
		this.otherId = otherId;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
