package studentdatabase.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import studentdatabase.dto.Student;

public class StudentDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("amit");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	// signup
	
	public Student saveStudent(Student student) {
		et.begin();
		em.persist(student);
		et.commit();
		
		return student;
	}
	
	public Student findStudent(int id) {
		Student existingStudent = em.find(Student.class, id);
		if(existingStudent!=null) {
			return existingStudent;
		}else {
			return null;
		}
	}
	
	public Student deleteStudent(int id) {
		Student existingStudent = findStudent(id);
		if(existingStudent!=null) {
			et.begin();
			em.remove(existingStudent);
			et.commit();
			return existingStudent;
		}
		else{
			return null;
		}
	}
	
	// login
	
	public Student loginStudent(String email, String password) {
		Query query = em.createQuery("select s from Student s where s.email=?1");
		query.setParameter(1, email);
		Student existingStudent = (Student)query.getSingleResult();
		if(existingStudent!=null) {
			if(existingStudent.getPassword().equals(password)) {
				return existingStudent;
			}
			return null;
		}
		return null;
		
	}
	
	public List<Student> getAllStudent(){
		Query query = em.createQuery("select s from Student s");
		List<Student> students = query.getResultList();
		if(!students.isEmpty()) {
			return students;
		}else {
			return null;
		}
	}
	
	public Student editStudent(int id, Student stu) {
		Student existingStudent = findStudent(id);
		if(existingStudent!=null) {
			stu.setId(id);
			et.begin();
			em.merge(stu);
			et.commit();
			return stu;
		}
		else {
			return null;
		}
		
	}
	
}
