package site.chiyu.dao;

import java.util.List;

import site.chiyu.bean.Comm;
import site.chiyu.bean.Dyna;

/***
 * 用户动态接口操作层
 * @author HOME
 *
 */
public interface DynaDao {
	public int add(Dyna dyna);
	
	public void delete(String dynaId);
	
	public Dyna getDyna(String dynaId);
	
	public int updateDyna(Dyna dyna);
	
	public List<Dyna> list();
	
	public List<Dyna> listWithMemId(String memId);
}
