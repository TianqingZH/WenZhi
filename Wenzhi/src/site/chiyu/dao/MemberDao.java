package site.chiyu.dao;

import java.util.List;

import site.chiyu.bean.Member;

/***
 * 数据接口层，与Member有关的数据操作，只定义接口操作方法，不涉及具体操作方法，层次清晰也便于解耦，其它类似，不再注解
 * @author HOME
 *
 */
public interface MemberDao {

	public int add(Member member);
	
	public void delete(String memId);
	
	public Member getMember(String memId);
	
	public int updateMember(Member member);
	
	public List<Member> list();
}
