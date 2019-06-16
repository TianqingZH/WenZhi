package site.chiyu.dao.impl;

import java.sql.Connection;
import java.util.List;

import site.chiyu.bean.Member;
import site.chiyu.dao.MemberDao;
import site.chiyu.utils.DB;

public class MemberDaoImpl implements MemberDao {


	@Override
	public int add(Member member) {
		int affectLine = 0;
		String sql = "insert into member(memId memId,pass pass,nickname nickname,sex sex,tx tx,sig sig,mctime mctime)"
				+ "values(?,?,?,?,?,?,?)";
		affectLine = new DB().executeUpdate(sql, member.getMemId(),member.getPass(),
				member.getNickname(),member.getSex(),member.getTx(),member.getSig(),member.getMctime());
		return affectLine;
	}

	@Override
	public void delete(String memId) {
		String sql = "delete from member where memId = ?";
		new DB().executeUpdate(sql, memId);
	}

	@Override
	public Member getMember(String memId) {
		String sql ="select * from member where memId=?";
		Member member = new DB().executeQuery(Member.class, sql, memId);
		return member;
	}

	@Override
	public int updateMember(Member member) {
		int affectLine = 0;
		String sql = "update member set memId=?,"
				+ "pass=?,nickname=?,sex=?,tx=?,sig=?,mctime=? where memId=?";
		affectLine = new DB().executeUpdate(sql, member.getMemId(),member.getPass(),
				member.getNickname(),member.getSex(),member.getTx(),member.getSig(),member.getMctime(),member.getMemId());
		return affectLine;
	}

	@Override
	public List<Member> list() {
		String sql ="select * from member ";
		List<Member> list = new DB().executeList(Member.class,sql, null);
		return list;
	}

}
