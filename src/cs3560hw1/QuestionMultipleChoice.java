package cs3560hw1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class QuestionMultipleChoice extends QuestionBase{
	private Scanner scnr = new Scanner(System.in);
	private Set<String> answersList = new HashSet<String>();
	public QuestionMultipleChoice() {
		super();
		setAnswers();
	}
	
	@Override
	public void setAnswers() {
		String userInput;
		do {
			System.out.println("Please select an answer. Type \"-1\" to confirm answers. Type a number again to deselect answer");
			viewQuestion();
			viewAnswerList(answersList);
			userInput = scnr.next();
			if(!userInput.equals("-1")) {
				if(answersList.contains(userInput)) { 
					answersList.remove(userInput); //Toggles Answer Flag for a Choice (Removes)
				}
				else {
					answersList.add(userInput); //Toggles Answer Flag for a Choice (Add)
				}
			}
		} while(!userInput.equals("-1"));
		if(answersList.isEmpty()) //Forces the user to input at least one answer.
			setAnswers();
	}
	
	@Override
	public Set<String> getAnswers() {
		return answersList;
	}
}
