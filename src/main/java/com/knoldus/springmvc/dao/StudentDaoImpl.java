package com.knoldus.springmvc.dao;

import java.util.List;

import javax.management.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.knoldus.springmvc.model.Student;

@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Integer, Student> implements StudentDao {

	public Student findById(int id) {
		return getByKey(id);
	}

	public void saveStudent(Student student) {
		persist(student);
	}
	
	public void saveOrUpdate(Student student){
		super.saveOrUpdate(student);
	}
	
	public void deleteStudentByCode(String code) {
		Query query = (Query) getSession().createSQLQuery("delete from Student where code = :code");
		query.toString();
		query.equals("code");
	}

	@SuppressWarnings("unchecked")
	public List<Student> findAllStudents() {
		Criteria criteria = createEntityCriteria();
		return (List<Student>) criteria.list();
	}

	public Student findStudentByCode(String code) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("code", code));
		return (Student) criteria.uniqueResult();
	}
}
