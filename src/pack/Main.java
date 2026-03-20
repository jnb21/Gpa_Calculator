package pack;

import java.util.Scanner;

public class Main {
	 
	static Scanner keyIn = new Scanner(System.in);
	static Linkedlist taken = new Linkedlist(); //To uses privates methods as well

	public static void main(String[] args){

		// TODO Auto-generated method stub		
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
			taken.displayAllCourses();
			break;
			
		case 4:
			double gpa = taken.calculateGPA();
			System.out.printf("Your current GPA is: %.2f\n", gpa);
		    break;
			
		case 5:
			System.out.println("You are exiting the program...");
			again = false;
			break;
		}
	}
}
	
	/**
	 * Private methods for the main class
	 * @return in the case of addCourse, returns true if course is added successfully, false otherwise
	 * 
	 * @method addCourse will add a course to the linkedlist of taken courses
	 * that will later use to help other oprations such as calculating GPA,
	 * removing courses, etc.
	 */


		public static boolean addCourse(){
			System.out.println("Enter the code of the course to add:(e.g., COMP248)");
			String name = keyIn.nextLine().trim().toUpperCase();

			System.out.println("Enter the number of credits the course is worth (0-6):");
			double credit = keyIn.nextDouble();
			keyIn.nextLine();

			// checking for valid credit value
			if (credit <= 0 || credit > 6) {
			    System.out.println("Invalid credit value. Please enter a value between 0 and 6.");
			    return false;
			}

			Course newCourse = new Course(name,credit);

			System.out.println("Enter your letter grade for the course (e.g., A, B+, C-):");
			String letterGrade = keyIn.nextLine().trim().toUpperCase();

			//getting GPA value from CourseManager
			Double gpaValue = CourseManager.convertLetterGradeToGpa(letterGrade);
			
			//Cheking gpa value
			if (gpaValue == null) {
			    System.out.println("Invalid letter grade. Please enter a valid letter grade (e.g., A, B+, C-).");
			    return false;
			}

			// Use of the declared Linkedlist that will hold added couses
			taken.addCourse(newCourse, gpaValue); 

		//to modify later
		return true;
	}
	
	/**
	 * @method removeCourseOption will remove a course from the linkedlist of taken courses
	 * if the course already exists in the list.
	 */
	
	private static boolean removeCourseOption() {
	System.out.println("Enter the code of the course to remove:(e.g., COMP248)");
	String name = keyIn.nextLine().trim().toUpperCase();
	
	return taken.removeCourse(name);
	}
}
