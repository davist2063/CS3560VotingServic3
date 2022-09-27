package cs3560hw1;

import java.util.Scanner;

public class SimulationDriver {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userInput;
		QuestionBase question = null;
		
		do {
			//Configure Question Type
			System.out.println("Hello! What kind of poll would you like to create?");
			System.out.println("1. Single Choice (One correct answer)");
			System.out.println("2. Multiple Choice (More than one correct answer)");
			System.out.println("-1. Exit Program");
			userInput = scnr.next();
			if(userInput.equals("1")) {
				question = new QuestionSingleChoice();
			}
			else if(userInput.equals("2")) {
				question = new QuestionMultipleChoice();
			}	
			//The rest of the program only executes if the user does not exit the program
			if(userInput.equals("1") || userInput.equals("2")) {
				//Configure Question
				System.out.println("Created Question!");
					//Configure Choices
					//Configure Answers
				//Generate Students
					//Pick StudentAnswers
				//Submit Student Answers
				//View Question Results.
			}
		}
		while(!userInput.equals("-1"));
	}

}
