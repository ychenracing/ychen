package cn.edu.fudan.iipl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.fudan.iipl.dao.StudentMyBatisDao;
import cn.edu.fudan.iipl.entity.Page;
import cn.edu.fudan.iipl.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentListController {

    private StudentMyBatisDao dao;

    @Autowired
    public void setDao(StudentMyBatisDao dao) {
        this.dao = dao;
    }

    @RequestMapping("/list")
    public String execute(Page page, Model model) {
        System.out.println("inlist");
        List<Student> list = dao.findAll();
        // JSONArray ja = new JSONArray();
        model.addAttribute("students", list);
        return "student/student_list";
    }

}
