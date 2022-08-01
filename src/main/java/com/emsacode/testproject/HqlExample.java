package com.emsacode.testproject;

import java.io.File;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.emsacode.model.Student;
import javax.persistence.*;

public class HqlExample {
	public static void main(String[] args) {
		String confFile = "hibernate.cfg.xml";
		ClassLoader classLoader = HqlExample.class.getClassLoader();
		File f = new File(classLoader.getResource(confFile).getFile());
		SessionFactory factory;
		try {
	        factory = new Configuration().
	                configure().
	                //addPackage("com.xyz") //add package if used.
	                        addAnnotatedClass(HqlExample.class).
	                        buildSessionFactory();
	    } catch (Throwable ex) {
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex);
	    }
//		SessionFactory sessionFactory = new AnnotationConfiguration().configure(f).buildSessionFactory();
		Session session = factory.openSession();
		//CREATE
		saveStudentRecord(session);
        //READ
		fetchStudentRecord(session);
		//UPDATE
		updateStudentRecord(session);
		//DELETE
//		deleteStudentRecord(session);
		session.close();
	}
	
	private static void deleteStudentRecord(Session session) {
		long id = 3;
		Student student1 = (Student) session.get(Student.class, new Long(id));
		session.beginTransaction();
		session.delete(student1);
		session.getTransaction().commit();
		System.out.println("Record deleted succesfully...");
	}
		
	private static void updateStudentRecord(Session session) {
		long  id = 4;
		Student student1 = (Student) session.get(Student.class, new Long(id));
		student1.setMajor("Business");
		
		session.beginTransaction();
		session.saveOrUpdate(student1);
		session.getTransaction().commit();
		System.out.println("Record updated succesfully...");
	}
		
	private static void fetchStudentRecord(Session session) {
		Query query = session.createQuery("FROM Student");
		List<Student> Students = query.list();
		Students.forEach(obj -> System.out.println(obj.getName()));
		System.out.println("Reading student records...");
		for (Student studentObj : Students) {
			System.out.println("Name " + studentObj.getName());
			System.out.println("Gender " + studentObj.getGender());
			System.out.println("Major " + studentObj.getMajor());
		}
	}
		
	private static void saveStudentRecord(Session session) {
		Student student1 = new Student();
		student1.setName("Jason Tatum");
		student1.setGender("Male");
		student1.setMajor("Software Engineering");
		
		session.beginTransaction();
		session.save(student1);
		session.getTransaction().commit();
		System.out.println("Record saved succesfully...");
	}
}