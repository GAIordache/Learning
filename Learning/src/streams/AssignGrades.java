package streams;

import java.util.stream.IntStream;

/*Write a program that reads student scores, gets the best score, and
then assigns grades based on the following scheme:
Grade is A if score is >= best -5
Grade is B if score is >= best -10;
Grade is C if score is >= best -15;
Grade is D if score is >= best -20;
Grade is F otherwise.*/
public class AssignGrades {

	public static void main(String[] args) {
		int[] grades = { 30, 50, 75 , 90, 65, 43};
		int max = IntStream.of(grades).max().getAsInt();
		IntStream.of(grades).forEach(grade -> System.out.println(grade + " = " + assignGrade(max, grade)));
	}
	
	public static String assignGrade(int max, int grade) {
		if(max-grade <= 5)
			return "A";
		else if(max - grade <= 10)
			return "B";
		else if(max - grade <= 15)
			return "C";
		else if(max - grade <= 20)
			return "D";
		else 
			return "F";
	}

}
