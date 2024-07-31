import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class TimerQuiz {
    public static void main(String[] args) {
        String[] questions = {
            " What is the range of the byte data type in Java?",
            " How do you declare an array in Java?",
            " Which of the following is a valid class name in Java?",
            " What keyword is used to inherit a class in Java?",
            " Which keyword is used for creating a constant in Java?",
            " What does the static keyword indicate in Java?",
            " Which loop is used to iterate over an array in Java?",
            " What is the output of the following code snippet? \nint x = 5; \n System.out.println(x++); \n System.out.println(++x);",
            " What is the purpose of the break statement in a loop?",
            " Which data type is used to store a single character in Java?"
        };

        String[] options = {
            "A) -128 to 127    B) 0 to 255   C) -32768 to 32767   D) 0 to 65535",
            "A) myArray[] int;   B) array myArray;   C) int[] myArray;  D) myArray = new Array();",
            "A) my-class   B) 123MyClass   C) My_Class   D) MyClass123",
            "A) implements   B) extends   C) inherits   D) inheritsFrom",
            "A) final   B) const   C) static   D) constant",
            "A) It makes a method non-static.\n  B) It allows access to instance variables.\n  C) It associates a method with the class, not an instance.\n  D) It restricts method access to the same package.",
            "A) foreach   B) while   C) do-while   D) for",
            "A) 5, 7    B) 6, 6     C) 5, 6    D) 6, 7",
            "A) To exit the loop immediately. \n B) To skip the current iteration. \n C) To continue to the next iteration. \n D) To terminate the program.",
            "A) byte   B) String    C) Character   D) char"
        };

        char[] correctAnswers = {'A', 'C', 'D', 'B', 'A', 'C', 'D', 'C', 'A', 'D'};

        String[] reasons = {
            "The byte data type in Java has a range from -128 to 127. It represents an 8-bit signed integer.",
            "To declare an array in Java, use the syntax data_type[] array_name;.",
            "Class names can start with letters (uppercase or lowercase) or underscores, followed by letters, digits, or underscores.",
            "The extends keyword creates a subclass that inherits properties and methods from a superclass.",
            "The final keyword declares constants with unchangeable values.",
            "static members belong to the class itself, not individual objects.",
            "The enhanced for loop iterates over elements in an array or collection.",
            "Post-increment (x++) prints the current value (5) and then increments. Pre-increment (++x) increments first and prints (6).",
            "break terminates the loop prematurely.",
            "char represents a single Unicode character."
        };

        AtomicInteger score = new AtomicInteger(0);
        Scanner scanner = new Scanner(System.in);
        AtomicInteger questionIndex = new AtomicInteger(0);
        Timer timer = new Timer();
        System.out.println("Welcome to Java Quiz");
        System.out.println("10 simple Java Questions will be asked");
        System.out.println("Each question Carries 1 point and time limit for every question is 20-seconds");
        System.out.println("Let's Begin the Quiz :-\n\n");
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                int currentIndex = questionIndex.getAndIncrement();
                if (currentIndex > 0) {
                    System.out.println("\n\nTime's up! Moving to the next question.\n\n");
                }
                if (currentIndex < questions.length) {
                    System.out.println("Question " + (currentIndex + 1) + ": " + questions[currentIndex]);
                    System.out.println(options[currentIndex]);
                    System.out.print("Your answer (A/B/C/D): ");
                    char answer = scanner.next().charAt(0);
                    if (Character.toUpperCase(answer) == correctAnswers[currentIndex]) {
                        score.incrementAndGet();
                        System.out.println("Correct! ");
                    } else {
                        System.out.println("Incorrect. " + reasons[currentIndex]);
                    }
                } else {
                    System.out.println("\nQuiz completed!");
                    System.out.println("Your score: " + score.get() + "/" + questions.length);
                    timer.cancel();
                }
            }
        };

        timer.schedule(task, 0, 20000);
    }
}
