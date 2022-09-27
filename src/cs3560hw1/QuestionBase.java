package cs3560hw1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class QuestionBase implements Question{
	private Scanner scnr = new Scanner(System.in);
	private String question = "";
	private Map<Integer, String> choicesList = new HashMap<Integer, String>();
	private Set<String> answersList = new HashSet<String>();

	QuestionBase() {
		setQuestion();
		setChoices();
	}
	
	@Override
	public void setQuestion() {
		System.out.println("Enter Question! Type \"-1\" to confirm question submission");
		do
			question = scnr.nextLine();
		while(!question.equals("-1"));
	}

	@Override
	public String getQuestion() {
		return question;
	}

	@Override
	//This method should be overridden by its child classes.
	public void setAnswers() {
		return;
	}

	@Override
	public Set<String> getAnswers() {
		return answersList;
	}

	@Override
	public void setChoices() {
		int counter = 1;
		String userInput;
		do {
			System.out.println("Enter Choice " + counter + ": (Enter \"-1\" to stop inputting choices)\n");
			userInput = scnr.nextLine();
			choicesList.put(counter, userInput);
			counter++;
		}
		while(!userInput.equals("-1"));
	}

	@Override
	public Map<Integer, String> getChoices() {
		return choicesList;
	}
	
	//Displays the Question
	public void viewQuestion() {
		System.out.println(question);
	}
		
	//Displays Choices.
	public void viewChoices(Set<String> answersList) {
		for(int i = 1; i < choicesList.size(); i++) {
			String temp = String.valueOf(i);
			if(answersList.contains(temp)) {
				System.out.print("* ");
			}
			System.out.println(i + ") " + choicesList.get(i));
		}
	}

}
