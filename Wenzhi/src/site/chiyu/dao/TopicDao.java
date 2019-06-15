package site.chiyu.dao;

import java.util.List;

import site.chiyu.bean.Member;
import site.chiyu.bean.Topic;

/***
 * 主题操作接口层
 * @author HOME
 *
 */
public interface TopicDao {
	public int add(Topic topic);
	
	public void delete(String topId);
	
	public Member getTopic(String topId);
	
	public int updateTopic(Topic topic);
	
	public List<Topic> list();
}
