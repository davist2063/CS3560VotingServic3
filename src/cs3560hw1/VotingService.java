package cs3560hw1;

public class VotingService {
	StudentList slist;
	QuestionBase question;
	int[] answerCounter;
	
	//Imports the student list and the question into the voting service.
	public VotingService(StudentList slist, QuestionWizard question) {
		this.slist = slist;
		this.question = question.getQuestion();
		answerCounter = new int[this.question.getChoices().size() + 1];
	}
	
	//Counts Results from Votes;
	public void submitAnswers() {
		if(question instanceof QuestionSingleChoice) {
			submitSingle();
		}
		else if(question instanceof QuestionMultipleChoice) {
			submitMultiple();
		}
	}
	
	//Submits Votes for Single Choice
	private void submitSingle() {
		for(Student values : slist.studentList.values()) { //Iterates through all of the students.
			int max = 0;
			int[] temp = values.getSelectedAnswers();
			for(int i = 1; i < answerCounter.length; i++) {
				if(temp[i] > max) {
					max = temp[i];
				}
			}
			answerCounter[max] += 1;
		}
	}
	
	//Submits Votes for Multiple Choice
	private void submitMultiple() {
		for(Student values : slist.studentList.values()) { //Iterates through all of the students.
			int[] temp = values.getSelectedAnswers();
			for(int i = 1; i < answerCounter.length; i++) {
				if(temp[i] != 0) {
					answerCounter[i] += 1;
				}
			}
		}
	}
	
	//Displays Results from Votes
	public void outputResults() {
		System.out.println(question.getQuestion());
		question.viewAnswerList(question.getAnswers());
		System.out.println("\nTotal Results!!!");
		for(int i = 1; i < answerCounter.length; i++) {
			System.out.print(i + ": " + answerCounter[i] + " votes, ");
		}
		System.out.println();
	}
}
