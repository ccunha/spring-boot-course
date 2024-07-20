package com.estudo.cruddemo;

import com.estudo.cruddemo.dao.StudentDAO;
import com.estudo.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRownsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: "+ numRownsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;

		System.out.println("Getting the student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student:");
		myStudent.setFirstName("John");
		studentDAO.update(myStudent);

		System.out.println("Updated student: "+myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		theStudents.forEach(student -> {
			System.out.println(student);
		});
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		theStudents.forEach(student -> {
			System.out.println(student);
		});
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating the new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@email.com");

		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Founded student:");
		System.out.println(myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student object ...");
		Student tempStudent1 = new Student("John", "Doe", "jonh@email.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@email.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@email.com");

		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating the new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@email.com");

		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
