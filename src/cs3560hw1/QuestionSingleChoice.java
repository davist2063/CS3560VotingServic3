package cs3560hw1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class QuestionSingleChoice extends QuestionBase{
	private Scanner scnr = new Scanner(System.in);
	private Set<String> answersList = new HashSet<String>();
	QuestionSingleChoice() {
		super();
		setAnswers();
	}
	
	@Override
	public void setAnswers() {
		String userInput;
		do {
			System.out.println("Please select an answer. Type \"-1\" to confirm answers.");
			viewQuestion();
			viewChoices(answersList);
			userInput = scnr.next();
			if(!userInput.equals("-1")) {
				answersList.clear();
				answersList.add(userInput);
			}
		} while(!userInput.equals("-1"));
		
		if(answersList.isEmpty()) //Forces the user to input at least one answer.
			setAnswers();
	}
}
