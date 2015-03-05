package webapp.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import webapp.Util.EmployeeDataSource;
import webapp.exception.DeptNotFoundException;
import webapp.model.Dept;
import webapp.model.Emp;
import webapp.service.DeptInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/webapp/spring/beans.xml")
public class DeptInfoServiceTest {

	static Logger log = Logger.getLogger(DeptInfoServiceTest.class);
	@Autowired
	ApplicationContext factory;

	@Test
	public void test1_GetDeptInfo() {
		log.info("### testGetDeptInfo");

		DeptInfoService service = factory.getBean(DeptInfoService.class);

		Dept dept = service.getDeptInfo(10);
		try {
			assertNotNull(dept);

			log.info("deptno = " + dept.getDeptno());
			log.info("dname = " + dept.getDname());
			log.info("loc = " + dept.getLoc());
		} catch (DeptNotFoundException e) {
			log.info("dept not found");
		}

	}

	@Test
	public void tset2_GetDeptInfoWithEmps() {
		log.info("###@@@ tsetGetDeptInfoWithEmps");

		DeptInfoService service = factory.getBean(DeptInfoService.class);

		Dept dept = service.getDeptInfoWithEmps(10);
		assertNotNull(dept);

		List<Emp> emps = dept.getEmps();
		if (emps != null) {
			for (Emp e : emps) {
				log.info(e.getEmpno() + " " + e.getEname());
			}
		}

		log.info("##################################");
	}
	
	@Test
	public void test3_GetDeptInfoAll(){
		DeptInfoService service = factory.getBean(DeptInfoService.class);
		List<Dept> list = service.getDeptInfoAll();
		assertNotNull(list);
		log.info("####################################");
		log.info("testGetDeptInfoAll()");
		for(Dept d : list){
			log.info(d.getDeptno() + " " + d.getDname()+" " + d.getLoc());
		}
	}

}
