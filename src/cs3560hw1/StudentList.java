package cs3560hw1;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class StudentList {
	private Random newNum = new Random();
	Map<Integer, Student> studentList = new HashMap<Integer, Student>();
	private int studentId;
	private int numStudents;
	
	//Creates a student list with a random number of students.
	StudentList() {
		this(0);
	}
	
	//Might give users the option to input the number of students.
	StudentList(int numStudents) {
		if(numStudents == 0) {
			this.numStudents = newNum.nextInt(5,15);
		}
		else
			this.numStudents = numStudents;
		addStudents();
	}
	
	//Adds students to the list of students in the classroom.
	private void addStudents() { 
		for(int i = 0; i < numStudents; i++) {
			studentId = newNum.nextInt(1001,9999);
			Student newStudent = new Student(studentId);
			studentList.put(studentId, newStudent);
		}
		return;
	}
	
	//Makes the question live and allows students to start voting.
	public void startPolling(QuestionBase question) {
		System.out.println("\n\nQuestion is Now Live:");
		for(Student values : studentList.values()) { //Iterates through all of the students.
			values.selectAnswer(question);
		}
	}
	
	//Prints the student list.
	public void viewStudentList() {
		System.out.println("Total Students Participating: " + studentList.size());
		for(Student values : studentList.values()) {
			System.out.println("ID: " + values.getId());
		}
		System.out.println("");
		return;
	}
}
