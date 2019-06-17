package site.chiyu.dao.impl;

import java.util.List;

import site.chiyu.bean.Member;
import site.chiyu.bean.Topic;
import site.chiyu.dao.TopicDao;
import site.chiyu.utils.DB;

@SuppressWarnings("unused")
public class TopicDaoImpl implements TopicDao {

	@Override
	public int add(Topic topic) {
		int affectLine = 0;
		String sql = "insert into topic(topId ,topCon,ctime ,mtime ,memId )"
				+ "values(?,?,?,?,?)";
		affectLine = new DB().executeUpdate(sql,topic.getTopId(),topic.getTopCon(),topic.getCtime(),topic.getMtime(),topic.getMemId());
		return affectLine;
	
	}

	@Override
	public void delete(String topId) {

		String sql = "delete from topic where topId = ?";
		new DB().executeUpdate(sql, topId);
	
	}

	@Override
	public Topic getTopic(String topId) {
		String sql ="select * from topic where topId=?";
		Topic topic = new DB().executeQuery(Topic.class, sql, topId);
		return topic;
		
	}

	@Override
	public int updateTopic(Topic topic) {
		int affectLine = 0;
		String sql = "update topic set topId=?,topCon=?"
				+ "ctime=?,mtime=?,memId=? where topId=?";
		affectLine = new DB().executeUpdate(sql, topic.getTopId(),topic.getTopCon(),topic.getCtime(),topic.getMtime(),topic.getMemId());
		return affectLine;
	}

	@Override
	public List<Topic> list() {
		String sql ="select * from topic ";
		List<Topic> list = new DB().executeList(Topic.class,sql, null);
		return list;
	}

}
