package site.chiyu.dao;

import java.util.List;

import site.chiyu.bean.Answer;
import site.chiyu.bean.Comm;
/***
 * 评论用户接口层
 * @author HOME
 *
 */
public interface CommDao {
	public int add(Comm comm);
	
	public int delete(String commId);
	
	public Comm getComm(String commId);
	
	public int updateComm(Comm comm);
	
	public List<Comm> list();
	
	public List<Comm> listWithAnswerId(String answerId);
}
