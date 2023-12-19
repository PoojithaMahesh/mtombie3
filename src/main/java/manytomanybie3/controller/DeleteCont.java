package manytomanybie3.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanybie3.dto.Course;
import manytomanybie3.dto.Student;

public class DeleteCont {
public static void main(String[] args) {
//	EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vinod");
//	EntityManager entityManager=entityManagerFactory.createEntityManager();
//	Student dbStudent=entityManager.find(Student.class, 1);
//	if(dbStudent!=null) {
////		i can delete
//		EntityTransaction entityTransaction=entityManager.getTransaction();
//		entityTransaction.begin();
//		entityManager.remove(dbStudent);
//		entityTransaction.commit();
//	}else {
//		System.out.println("Sorry id is not present");
//	}
	
	
	
	
	EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	Course dbCourse=entityManager.find(Course.class, 1);
	if(dbCourse!=null) {
//		i can delete
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
		List<Student> students=dbCourse.getStudents();
		for(Student student:students) {
			List<Course> courses=student.getCourses();
			courses.remove(dbCourse);
			student.setCourses(courses);
		}
		entityManager.remove(dbCourse);
		entityTransaction.commit();
	}else {
		System.out.println("Sorry id is not present");
	}
	
	
	
	
	
	
	
	
}
}
