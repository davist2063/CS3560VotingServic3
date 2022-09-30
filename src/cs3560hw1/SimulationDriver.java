package cs3560hw1;

import java.util.Scanner;

public class SimulationDriver {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userInput;
		
		//Generate Student List
		StudentList studentlist = new StudentList(); //Creates student list of 2 students
		studentlist.viewStudentList();
		
		//Configure Question Type, Question, Choices, and Answers
		QuestionWizard question = new QuestionWizard();
		
		if(question.getQuestion() != null) {
			//Pick StudentAnswers
			studentlist.startPolling(question.getQuestion()); //Opens the question for students to answers.
			
			//Submit Student Answers
			VotingService voteTool = new VotingService(studentlist, question);
			voteTool.submitAnswers();
			
			//View Question Results.
			voteTool.outputResults();
		}		 
	}
}
