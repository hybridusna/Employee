package webapp.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import webapp.dao.DeptDao;
import webapp.model.Dept;
import webapp.model.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/webapp/spring/beans.xml")
public class DeptDaoTest {

	static Logger log = Logger.getLogger(DeptDaoTest.class);
	
	@Autowired
	ApplicationContext factory;
	
	@Test
	public void test1_SelectByDeptno() throws SQLException {
		DeptDao dao = factory.getBean(DeptDao.class);
		
		Dept dept = dao.selectByDeptno(10);
		
		log.info("deptno = "+dept.getDeptno());
		log.info("dname = " + dept.getDname());
		log.info("loc = " + dept.getLoc());
		
		if(dept.getEmps() != null)
		for (Emp e : dept.getEmps()){
			log.info("empno = + " + e.getEmpno() + " " + e.getEname());
		}
		
	}
	
	@Test
	public void test2_SelectByDeptnoWithEmps() throws SQLException {
		DeptDao dao = factory.getBean(DeptDao.class);
		
		Dept dept = dao.selectByDeptnoWithEmps(10);
		assertNotNull(dept);
		
		log.info("deptno = "+dept.getDeptno());
		log.info("dname = " + dept.getDname());
		log.info("loc = " + dept.getLoc());
		
	}
	
	@Test
	public void test3_SelectAll() {
		log.info("########################################");
		log.info("testSelectAll");
		DeptDao dao = factory.getBean(DeptDao.class);
		List<Dept> list = dao.selectAll();
		assertNotNull(list);
		
		for(Dept d : list){
			log.info(d.getDeptno() + " " + d.getDname()+" " + d.getLoc());
		}
		
	}

}
