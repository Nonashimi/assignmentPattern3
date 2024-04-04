package com.luv2code.cruddemo;

import com.luv2code.cruddemo.Dao.StudentDao;
import com.luv2code.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {

		return runner -> {
			// createStudent(studentDao);

			 createMultipleStudents(studentDao);

			// readStudent(studentDao);

			// queryForStudent(studentDao);

			// queryForStudentsByLastName(studentDao);

			// updateStudent(studentDao);

			// deleteStudent(studentDao);

			// deleteAllStudent(studentDao);
		};
	}

	private void deleteAllStudent(StudentDao studentDao) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDao.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDao studentDao) {

		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDao.delete(3);
	}

	private void updateStudent(StudentDao studentDao) {
		// retriev student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDao.findById(studentId);

		// change first name to "Scooby"
		System.out.println("Updating student...");
		myStudent.setFirstName("Dies");

		// update the student
		studentDao.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent );
	}

	private void queryForStudentsByLastName(StudentDao studentDao) {
		// get list of student
		List<Student> theStudents = studentDao.findByLastName("Dao");

		// display list of students
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void createMultipleStudents(StudentDao studentDao) {

		// create multiple students
		System.out.println("Creating 3 student objects....");
		Student tempStudent1 = new Student("John","Dao","john@luv2code.com");
		Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita","Applebum","bonita@luv2code.com");

		// save the student objects
		System.out.println("Saving the students...");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);

	}

	private void createStudent(StudentDao studentDao) {

		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul","Dao","paul@luv2code.com");

		//save the student object
		System.out.println("Saving the student: ...");
		studentDao.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

	private void readStudent(StudentDao studentDao) {

		// create a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "duffy@luv2code.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDao.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrive student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDao.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}
	private void queryForStudent(StudentDao studentDao) {
		// get a list of students
		List<Student> theStudents = studentDao.findAll();

		// display list of students
		for (Student student: theStudents) {
			System.out.println(student);
		}
	}
}
