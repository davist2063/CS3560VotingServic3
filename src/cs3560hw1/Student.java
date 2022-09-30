package cs3560hw1;

import java.util.Random;

public class Student {
	private int id;
	private int[] answersSelected;
	
	public Student(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//The student selects their answer.
	public void selectAnswer(QuestionBase question) {
		Random rand = new Random();
		answersSelected = new int[question.getChoices().size() + 1];
		int maxOptionSelected = 0;

		//Handles the answer selection process.
		for(int i = 1; i <= question.getChoices().size(); i++) {
			int rand1 = rand.nextInt(101);
			int rand2 = rand.nextInt(50);
			int rand3 = rand.nextInt(40);
			int rand4 = 0;
			
			if(question instanceof QuestionSingleChoice) { //Reduces chances of answer overwriting.
				rand4 = rand.nextInt(i) * -8;
			}
			if(question.getAnswers().contains(String.valueOf(i))) { //Correct Answers are more likely to get picked
				if(rand1 <= rand2 + rand3) {
					answersSelected[i] = i;
					maxOptionSelected = i;
				}
			}
			else if(question instanceof QuestionMultipleChoice) { //Incorrect Answers are less likely to get picked.
				if(rand1 <= rand2) {
					answersSelected[i] = i;
					maxOptionSelected = i;
				}
			}
			else { //Incorrect Answers are less likely to get picked.
				if(rand1 <= rand2 + rand4) {
					answersSelected[i] = i;
					maxOptionSelected = i;
				}
			}
		}
		if(maxOptionSelected == 0) {
			if(question instanceof QuestionSingleChoice) { //Chooses A Value At Random for Single Questions
				int randomValue = rand.nextInt(answersSelected.length);
				answersSelected[randomValue] = randomValue;
			}
		}
	}
	
	public int[] getSelectedAnswers() {
		return answersSelected;
	}
}
