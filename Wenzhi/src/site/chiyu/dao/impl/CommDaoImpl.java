package site.chiyu.dao.impl;

import java.sql.Connection;
import java.util.List;


import site.chiyu.bean.Comm;
import site.chiyu.dao.CommDao;
import site.chiyu.utils.DB;

public class CommDaoImpl implements CommDao {

	
	
	@Override
	public int add(Comm comm) {
		int affectLine = 0;
		String sql = "insert into comm(commId ,commCon,ctime ,answerId ,memId)"
				+ "values(?,?,?,?,?)";
		affectLine = new DB().executeUpdate(sql,comm.getCommId(),comm.getCommCon(),comm.getCtime(),comm.getAnswerId(),comm.getMemId());
		return affectLine;
	}

	@Override
	public void delete(String commId) {
		String sql = "delete from comm where commId = ?";
		new DB().executeUpdate(sql, commId);
		
	}

	@Override
	public Comm getComm(String commId) {
		String sql ="select * from comm where commId=?";
		Comm comm = new DB().executeQuery(Comm.class, sql, commId);
		return comm;
	}

	@Override
	public int updateComm(Comm comm) {
		int affectLine = 0;
		String sql = "update comm set commId=?,commCon=?"
				+ "ctime=?,answerId=?,memId=? where commId=?";
		affectLine = new DB().executeUpdate(sql,comm.getCommId(),comm.getCommCon(),comm.getCtime(),comm.getAnswerId(),comm.getMemId(),comm.getCommId());
		return affectLine;
	}

	@Override
	public List<Comm> list() {
		String sql ="select * from comm ";
		List<Comm> list = new DB().executeList(Comm.class,sql,null);
		return list;
	}

}
