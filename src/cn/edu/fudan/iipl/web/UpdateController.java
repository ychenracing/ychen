package cn.edu.fudan.iipl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.fudan.iipl.dao.StudentMyBatisDao;
import cn.edu.fudan.iipl.entity.Student;

@Controller
@RequestMapping("/student")
public class UpdateController {
	private StudentMyBatisDao dao;
	@Autowired
	public void setDao(StudentMyBatisDao dao){
		this.dao = dao;
	}
	@RequestMapping(value="/{id}/toUpdate",method=RequestMethod.GET)
	public String toUpdate(@PathVariable("id") int id,Model model){
		Student student = dao.findById(id);
		model.addAttribute("student", student);
		return "student/student_modify";
	}
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String update(Student student){
		dao.updateStudent(student);
		return "redirect:list";
	}
}
