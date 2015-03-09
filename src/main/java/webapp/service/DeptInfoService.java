package webapp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import webapp.Util.EmployeeDataSource;
import webapp.Util.GlobalVars;
import webapp.dao.DeptDao;
import webapp.exception.ConnectionFailException;
import webapp.exception.DeptAccessException;
import webapp.exception.DeptNotFoundException;
import webapp.model.Dept;

public class DeptInfoService {
	DeptDao deptdao;

	DataSource dataSource;

	public void setDeptDao(DeptDao dao) {
		deptdao = dao;
	}

	public void setDataSource(DataSource ds) {
		dataSource = ds;
	}

	public Dept getDeptInfo(Integer deptno) {
		// All or nothing (트랜잭션의 특징, 하나 예외 발생하면 전체가 시작전으로 돌아감)

		Dept dept = deptdao.selectByDeptno(deptno);

		return dept;
	}

	public Dept getDeptInfoWithEmps(Integer deptno) {

		Dept dept = deptdao.selectByDeptnoWithEmps(deptno);

		return dept;

	}

	public List<Dept> getDeptInfoAll() {
		List<Dept> list = deptdao.selectAll();

		return list;

	}

	public List<Dept> getDeptInfoAllWithEmps() {
		List<Dept> list = deptdao.selectAllWithEmps();

		return list;
	}

}
