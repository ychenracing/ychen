package cn.edu.fudan.iipl.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.fudan.iipl.dao.StudentMyBatisDao;
import cn.edu.fudan.iipl.entity.Student;

public class TestStudentDAO {
	
	@Test
	public void testFindAll(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		StudentMyBatisDao sd = ac.getBean("studentMyBatisDao",StudentMyBatisDao.class);
		List<Student> list = sd.findAll();
		for(Student student:list){
			System.out.println(student.getId()+":"+student.getName());
		}
	}

}
