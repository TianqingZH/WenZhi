package site.chiyu.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.sun.deploy.uitoolkit.impl.fx.Utils;

import site.chiyu.bean.Answer;
import site.chiyu.bean.Member;
import site.chiyu.dao.AnswerDao;
import site.chiyu.utils.DB;

public class AnswerDaoImpl implements AnswerDao {


	

	@Override
	public int add(Answer answer) {
		int affectLine = 0;
		String sql = "insert into answer(answerId ,ansCon,zan ,comCount ,ctime ,memId ,topId )"
				+ "values(?,?,?,?,?,?,?)";
		affectLine = new DB().executeUpdate(sql, answer.getAnswerId(),answer.getAnsCon(),answer.getZan(),answer.getComCount(),answer.getCtime(),answer.getMemId(),answer.getTopId());
		return affectLine;
	}

	@Override
	public int delete(String answerId) {
		int res = 0;
		String sql = "delete from answer where answerId = ?";
		res = new DB().executeUpdate(sql, answerId);
		return res;
	}

	@Override
	public Answer getAnswer(String answerId) {
		String sql ="select * from answer where answerId=?";
		Answer answer = new DB().executeQuery(Answer.class, sql, answerId);
		return answer;
	
	}

	@Override
	public int updateAnswer(Answer answer) {
		int affectLine = 0;
		String sql = "update answer set answerId=?,ansCon=?,"
				+ "zan=?,comCount=?,ctime=?,memId=?,topId=? where answerId=?";
		affectLine = new DB().executeUpdate(sql,answer.getAnswerId(),answer.getAnsCon(),answer.getZan(),answer.getComCount(),answer.getCtime(),answer.getMemId(),answer.getTopId(),answer.getAnswerId() );
		return affectLine;
	
	}

	@Override
	public List<Answer> list() {
		String sql ="select * from answer ";
		List<Answer> list = new DB().executeList(Answer.class,sql, null);
		return list;
		
	}

	
	@Override
	public List<Answer> listWithTopId(String topId) {
		String sql ="select * from answer where topId=?";
		List<Answer> list = new DB().executeList(Answer.class,sql, topId);
		return list;
	}

	@Override
	public Answer getAnswerWithTopId(String topId) {
		String sql ="select * from answer where topId=\"?\"";
		Answer answer = new DB().executeQuery(Answer.class, sql, topId);
		return answer;
	}

}
