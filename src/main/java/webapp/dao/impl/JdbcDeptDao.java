package webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.DataSourceUtils;

import webapp.Util.GlobalVars;
import webapp.dao.DeptDao;
import webapp.exception.DeptNotFoundException;
import webapp.model.Dept;
import webapp.model.Emp;

public class JdbcDeptDao implements DeptDao {

	static Logger log = Logger.getLogger(JdbcDeptDao.class);

	DataSource dataSource;

	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		// TODO Auto-generated method stub

	}

	@Override
	public Dept selectByDeptno(Integer deptno) {
		// TODO Auto-generated method stub
		log.info("###################################");
		log.info("selectByDeptno(" + deptno + ")");
		log.info("###################################");
		Connection con = DataSourceUtils.getConnection(dataSource);
		Dept dept = null;

		try{
		PreparedStatement pstmt = con.prepareStatement(SELECT_BY_DEPTNO);
		pstmt.setInt(1, deptno);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			dept = new Dept();
			dept.setDeptno(rs.getInt("deptno"));
			dept.setDname(rs.getString("dname"));
			dept.setLoc(rs.getString("loc"));
		}
		} catch (SQLException e){
			throw new DataRetrievalFailureException("Fail", e);
		}
		
		if(dept == null){
			throw new EmptyResultDataAccessException("dept empty row",1);
		}

		return dept;

	}

	@Override
	public Dept selectByDeptnoWithEmps(Integer deptno) {
		// TODO Auto-generated method stub
		log.info("######################################");
		log.info("selectByDeptnoWithEmps(" + deptno + ")");
		log.info("######################################");
		Dept dept = null;
		List<Emp> emps = null;
		Connection con = DataSourceUtils.getConnection(dataSource);
		try{
		PreparedStatement pstmt = con.prepareStatement(SELECT_BY_DEPTNO_WITH_EMPS);
		
			pstmt.setInt(1, deptno);
		

		ResultSet rs = pstmt.executeQuery();

		

		while (rs.next()) {
			if (dept == null) {
				dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				emps = new ArrayList<Emp>();
			}

			Emp emp = new Emp();
			emp.setEmpno(rs.getInt("empno"));
			emp.setEname(rs.getString("ename"));
			emp.setJob(rs.getString("job"));
			emp.setMgr(rs.getInt("mgr"));
			emp.setHiredate(rs.getDate("hiredate"));
			emp.setSal(rs.getFloat("sal"));
			emp.setComm(rs.getFloat("comm"));
			
			emps.add(emp);

		}
		} catch (SQLException e){
			throw new DataRetrievalFailureException("faill...", e);
		}
		
		if(dept!=null){
			dept.setEmps(emps);
		} 
		
		return dept;
	}

	@Override
	public List<Dept> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> selectAllWithEmps() {
		// TODO Auto-generated method stub
		return null;
	}

}
