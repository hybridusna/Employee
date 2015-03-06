package webapp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import webapp.model.Dept;

public interface DeptDao {
	
	final static String SELECT_BY_DEPTNO = "select * from dept where deptno = ?";
	final static String SELECT_BY_DEPTNO_WITH_EMPS ="select * from dept d "+
													"left join emp e on d.deptno = e.deptno "+
													"where d.deptno =?";
	
	final static String SELECT_ALL = "select * from dept";
	final static String SELECT_ALL_WITH_EMPS ="select d.deptno as deptno, "+
											  "       d.dname  as dname, "+
										   	  "       d.loc    as loc, "+
											  "       e.empno  as empno, "+
											  "       e.job    as job, "+
											  "        e.mgr   as mgr, "+
											  "     e.hiredate as hiredate, "+
											  "       e.sal	   as sal, "+
											  "     e.comm     as comm "+
											  "left join outer emp e " +
											  "on d.deptno = e.deptno " + 
											  "order by d.deptno asc, e.empno desc ";
	
	public void setDataSource(DataSource ds);
	
	/*
	 * Single row by primary key
	 */
	public Dept selectByDeptno(Integer deptno) ;
	public Dept selectByDeptnoWithEmps(Integer deptno);
	
	/*
	 * Multiple row
	 */
	public List<Dept> selectAll();
	public List<Dept> selectAllWithEmps();
	

}
