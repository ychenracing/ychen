package cn.edu.fudan.iipl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.fudan.iipl.dao.StudentMyBatisDao;
import cn.edu.fudan.iipl.entity.Student;

@Controller
@RequestMapping("/student")
public class AddStudentController {
	private StudentMyBatisDao dao;
	@Autowired
	public void setDao(StudentMyBatisDao dao){
		this.dao = dao;
	}
	
	@RequestMapping(value="/toAdd",method=RequestMethod.GET)
	public String toAdd(Model model){
		Student student = new Student();
		model.addAttribute("student",student);
		return "student/student_add";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Student student){
		dao.addStudent(student);
		return "redirect:list";
	}
}
