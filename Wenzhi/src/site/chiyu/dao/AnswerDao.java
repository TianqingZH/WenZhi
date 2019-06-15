package site.chiyu.dao;

import java.util.List;

import site.chiyu.bean.Answer;
import site.chiyu.bean.Member;

/***
 * 回答操作接口层
 * @author HOME
 *
 */
public interface AnswerDao {
	public int add(Answer answer);
	
	public void delete(String answerId);
	
	public Member getAnswer(String answerId);
	
	public int updateAnswer(Answer answer);
	
	public List<Answer> list();
	
	
}
