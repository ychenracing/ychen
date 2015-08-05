package cn.edu.fudan.iipl.dao;

import java.util.List;

import cn.edu.fudan.iipl.annotation.MyBatisDao;
import cn.edu.fudan.iipl.entity.Student;

@MyBatisDao
public interface StudentMyBatisDao {
	public List<Student> findAll();
	public Student findById(int id);
	public void updateStudent(Student student);
	public void addStudent(Student student);
	public void deleteById(int id);
    public int findByName(String name);
}