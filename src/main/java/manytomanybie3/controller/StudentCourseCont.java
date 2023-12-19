package manytomanybie3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanybie3.dto.Course;
import manytomanybie3.dto.Student;

public class StudentCourseCont {
public static void main(String[] args) {
	Course course1=new Course();
	course1.setId(1);
	course1.setName("Java");
	course1.setFees(50000);
	
	Course course2=new Course();
	course2.setId(2);
	course2.setName("AdvJava");
	course2.setFees(50000);
	
	Student student1=new Student();
	student1.setId(1);
	student1.setName("Venkata");
	student1.setAddress("Chennai");
	
	List<Course> coursesOfVenkata=new ArrayList<Course>();
	coursesOfVenkata.add(course2);
	coursesOfVenkata.add(course1);
	
	student1.setCourses(coursesOfVenkata);
	
	Student student2=new Student();
	student2.setId(2);
	student2.setName("Jeevitha");
	student2.setAddress("Bangalore");
	
	student2.setCourses(coursesOfVenkata);
	
	
	List<Student> students=new ArrayList<Student>();
	students.add(student2);
	students.add(student1);
	
	course1.setStudents(students);
	course2.setStudents(students);
	
	
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction  entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(student1);
	entityManager.persist(student2);
	entityManager.persist(course1);
	entityManager.persist(course2);
	entityTransaction.commit();
}
}
