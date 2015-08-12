package cn.edu.fudan.iipl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.fudan.iipl.dao.StudentMyBatisDao;

@Controller
@RequestMapping("/student")
public class DeleteStudentController {
    private StudentMyBatisDao dao;

    @Autowired
    public void setDao(StudentMyBatisDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(int id) {
        dao.deleteById(id);
        return true;
    }
}
