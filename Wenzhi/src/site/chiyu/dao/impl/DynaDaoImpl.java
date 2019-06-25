package site.chiyu.dao.impl;

import java.util.List;

import site.chiyu.bean.Dyna;
import site.chiyu.dao.DynaDao;
import site.chiyu.utils.DB;

public class DynaDaoImpl implements DynaDao {

	@Override
	public int add(Dyna dyna) {
		int affectLine = 0;
		String sql = "insert into dyna(dynaId ,memId,ctime ,otherId ,flag)"
				+ "values(?,?,?,?,?)";
		affectLine = new DB().executeUpdate(sql,dyna.getDynaId(),dyna.getMemId(),dyna.getCtime(),dyna.getotherId(),dyna.getFlag());
		return affectLine;
	}

	@Override
	public void delete(String dynaId) {
		String sql = "delete from dyna where dynaId = ?";
		new DB().executeUpdate(sql, dynaId);
		
	}

	@Override
	public Dyna getDyna(String dynaId) {
		String sql ="select * from dyna where dynaId=?";
		Dyna dyna = new DB().executeQuery(Dyna.class, sql, dynaId);
		return dyna;
	}
	
	
	//根据三个值同时查询动态表中是否已经被赞同或评论过
	@Override
	public Dyna getDynaBymemIdandotherIdandflag(String memId, String otherId, String flag) {
		String sql = "select *  from dyna where memId = ? and otherId= ? and flag = ?";
		System.out.println("现在将要执行sql语句了！");
		Dyna dyna = new DB().executeQuery(Dyna.class, sql, memId, otherId, flag);
		//System.out.println("在查询这查到的："+dynaId);
		return dyna;
	}

	@Override
	public int updateDyna(Dyna dyna) {
		int affectLine = 0;
		String sql = "update dyna set dynaId=?,memId=?"
				+ "ctime=?,otherId=?,flag=? where dynaId=?";
		affectLine = new DB().executeUpdate(sql,dyna.getDynaId(),dyna.getMemId(),dyna.getCtime(),dyna.getotherId(),dyna.getFlag(),dyna.getDynaId());
		return affectLine;
	}

	@Override
	public List<Dyna> list() {
		String sql ="select * from dyna ";
		List<Dyna> list = new DB().executeList(Dyna.class,sql,null);
		return list;
	}

	@Override
	public List<Dyna> listWithMemId(String memId) {
		String sql ="select * from dyna where memId=?";
		List<Dyna> list = new DB().executeList(Dyna.class,sql, memId);
		return list;
	}

	@Override
	public int deleteByOtherId(String otherId) {
		int res = 0;
		String sql = "delete from dyna where otherId = ?";
		res =new DB().executeUpdate(sql, otherId);
		return res;
	}

}
