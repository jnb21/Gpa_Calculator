package pack;

import java.util.Scanner;

public class Main {
	 
	static Scanner keyIn = new Scanner(System.in);
	static CourseManager manager = new CourseManager ();

	public static void main(String[] args){

		displayMenu();
	}

		public static void displayMenu(){
					
		boolean again = true;	
		
	System.out.println("===================  WELCOME TO THE STUDENT GPA CALCULATOR  =================");
	
	while(again) {
		System.out.print("\n1. Add a Course\n2. Remove a Course\n3. View All Courses"
				+ "\n4. Calculate GPA\n5. Exit \n\nEnter your choice: ");
		
		int choice = keyIn.nextInt();
		
		keyIn.nextLine();
		
		switch (choice) {
		case 1:
			addCourse();
			break;

		case 2:
			removeCourseOption();
			break;
		
		case 3:
			try{
			manager.displayCourses();
			} catch (EmptyCourseListException e){
				System.out.println(e.getMessage());
			}
			break;
			
		case 4:
			try {
			double gpa = manager.calculateGPA();
			System.out.printf("Your current GPA is: %.2f\n", gpa);
			} catch (EmptyCourseListException e){
				System.out.println(e.getMessage());
			}
		    break;
			
		case 5:
			System.out.println("You are exiting the program...");
			again = false;
			break;
		}
	}
	}
	

		public static void addCourse() {
			System.out.println("Enter the code of the course to add:(e.g., COMP248)");
			String name = keyIn.nextLine().trim().toUpperCase();

			System.out.println("Enter the number of credits the course is worth (0-6):");
			double credit = keyIn.nextDouble();
			keyIn.nextLine();

			System.out.println("Enter your recieved letter grade from the course: ");
			String letterGrade = keyIn.nextLine().trim().toUpperCase();

			Course newCourse = new Course(name,letterGrade,credit);
			
			try{
			manager.addCourse(newCourse);
			} catch (InvalidGradeException e){
				System.out.println(e.getMessage());
			} catch (DuplicateCourseException e){
				System.out.println(e.getMessage());
			}
	}
	
	
	
	private static void removeCourseOption(){
	try{
	System.out.println("Enter the code of the course to remove:(e.g., COMP248)");
	String name = keyIn.nextLine().trim().toUpperCase();

	Course rmd = manager.getCourse(name);

	manager.removeCourse(rmd);

	} catch (CourseNotFoundException e){
		System.out.println(e.getMessage());
	}
	}
}