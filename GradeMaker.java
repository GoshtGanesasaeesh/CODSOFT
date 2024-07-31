import java.util.Scanner;

public class GradeMaker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter marks for subject 1: ");
        int subject1 = scanner.nextInt();

        System.out.print("Enter marks for subject 2: ");
        int subject2 = scanner.nextInt();

        System.out.print("Enter marks for subject 3: ");
        int subject3 = scanner.nextInt();
	
	System.out.print("Enter marks for subject 4: ");
        int subject4 = scanner.nextInt();

	System.out.print("Enter marks for subject 5: ");
        int subject5 = scanner.nextInt();

        int totalMarks = subject1 + subject2 + subject3 + subject4 + subject5;

        int numSubjects = 5;
        double averagePercentage = (double) totalMarks / numSubjects;

        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else {
            grade = 'D';
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
