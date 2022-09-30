package cs3560hw1;

import java.util.Scanner;

public class QuestionWizard {
	private Scanner scnr = new Scanner(System.in);
	private QuestionBase question;
	
	public QuestionWizard() {
		createQuestion();
	}
	
	//Creates a console based UI that allows the user to create a question.
	private void createQuestion() {
		scnr = new Scanner(System.in);
		String userInput;
		System.out.println("Hello! What kind of question would you like to create?");
		System.out.println("1. Single Choice (One correct answer)");
		System.out.println("2. Multiple Choice (More than one correct answer)");
		System.out.println("-1. Exit Program");
		userInput = scnr.next();
		
		//Creates appropriate question type
		if(userInput.equals("1")) {
			question = new QuestionSingleChoice();
		}
		else if(userInput.equals("2")) {
			question = new QuestionMultipleChoice();
		}	
		
		//The rest of the program only executes if the user does not exit the program
		if(userInput.equals("1") || userInput.equals("2")) {
			System.out.println("Created Question!");
		}
		return;
	}

	//Returns question string.
	public QuestionBase getQuestion() {
		return question;
	}
	
}
