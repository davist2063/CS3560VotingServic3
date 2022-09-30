package cs3560hw1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public abstract class QuestionBase implements Question{
	private Scanner scnr = new Scanner(System.in);
	private String question = "";
	private Map<Integer, String> choicesList = new HashMap<Integer, String>();
	private Set<String> answersList = new HashSet<String>();

	public QuestionBase() {
		setQuestion();
		setChoices();
	}
	
	@Override
	public void setQuestion() {
		String temp;
		System.out.println("Enter Question! Type \"-1\" to confirm question submission");
		do {
			temp = scnr.nextLine();
			if(!temp.equals("-1")) {
				question = temp;
			}
		}
		while(!temp.equals("-1"));
	}

	@Override
	public String getQuestion() {
		return question;
	}

	@Override
	public abstract void setAnswers(); //This method should be overridden by its child classes.

	@Override
	public abstract Set<String> getAnswers(); //This method should be overridden by its child classes

	@Override
	public void setChoices() { //This method allows the users to input answer choices.
		int counter = 1;
		String userInput;
		do {
			System.out.println("Enter Choice " + counter + ": (Enter \"-1\" to stop inputting choices)");
			userInput = scnr.nextLine();
			if(!userInput.equals("-1")) {
				choicesList.put(counter, userInput);
				counter++;
			}
		}
		while(!userInput.equals("-1"));
		if(choicesList.isEmpty()) //Forces the user to input at least one choice.
			setChoices();
	}

	@Override
	public Map<Integer, String> getChoices() { //Returns the choices for a given question.
		return choicesList;
	}
	
	//Displays the Question
	public void viewQuestion() {
		System.out.println(question);
		return;
	}
		
	//Displays Choices.
	public void viewAnswerList(Set<String> answersList) {
		for(int i = 1; i <= choicesList.size(); i++) {
			String temp = String.valueOf(i);
			if(answersList.contains(temp)) {
				System.out.print("* ");
			}
			System.out.println(i + ") " + choicesList.get(i));
		}
	}

}
