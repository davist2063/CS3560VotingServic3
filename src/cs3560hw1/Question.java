package cs3560hw1;

import java.util.Map;
import java.util.Set;

public interface Question {
	void setQuestion();
	String getQuestion();
	void setChoices();
	Map<Integer, String> getChoices();
	void setAnswers();
	Set<String> getAnswers();
}
