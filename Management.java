import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int enrolledStudents;

    public Course(String code, String title, String description, int capacity, String schedule, int enrolledStudents) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = enrolledStudents;
    }

    public boolean isFull() {
        return enrolledStudents >= capacity;
    }

    public void enrollStudent() {
        if (!isFull()) {
            enrolledStudents++;
        }
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", schedule='" + schedule + '\'' +
                ", enrolledStudents=" + enrolledStudents +
                '}';
    }
}

class Student {
    private int studentId;
    private String name;
    private List<String> registeredCourses;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        if (!course.isFull()) {
            registeredCourses.add(course.getCode());
            course.enrollStudent();
        } else {
            System.out.println("Course " + course.getCode() + " is full. Please select another course.");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", registeredCourses=" + registeredCourses +
                '}';
    }
}

public class Management {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String collegeName = "Aditya Engineering College";

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CSE", "Introduction to Computer Science", "Basic concepts of computer science", 30, "MWF 9:00 AM", 30)); 
        courses.add(new Course("ECE", "Introduction to Electronics", "Basic concepts of electronics", 25, "TTh 1:30 PM", 22)); 
        courses.add(new Course("EEE", "Introduction to Electrical Engineering", "Basic concepts of electrical engineering", 20, "MWF 11:00 AM", 15));
        courses.add(new Course("CIV", "Introduction to Civil Engineering", "Basic concepts of civil engineering", 30, "TTh 10:00 AM", 15)); 
        courses.add(new Course("MECH", "Introduction to Mechanical Engineering", "Basic concepts of mechanical engineering", 25, "MWF 2:00 PM", 5)); 

        System.out.println("Welcome to " + collegeName + "!");
        System.out.println("Available courses:");
        for (Course course : courses) {
            System.out.println(course + "\n");
        }

        System.out.println("\nEnter student details:");
        System.out.print("Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();

        Student student = new Student(studentId, name);

        while (true) {
            System.out.print("Enter course code to register (or 'exit' to finish): ");
            String courseCode = scanner.nextLine();
            if (courseCode.equalsIgnoreCase("exit")) {
                break;
            }

            boolean courseFound = false;
            for (Course course : courses) {
                if (course.getCode().equalsIgnoreCase(courseCode)) {
                    student.registerCourse(course);
                    courseFound = true;
                    break;
                }
            }

            if (!courseFound) {
                System.out.println("Course not found. Please try again.");
            }
        }

        System.out.println("\nStudent details:");
        System.out.println(student);

        scanner.close();
    }
}
