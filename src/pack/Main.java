package pack;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	 
	static Scanner keyIn = new Scanner(System.in);
	static CourseManager manager = new CourseManager ();

	public static void main(String[] args){

		displayMenu();
	}

		public static void displayMenu() throws InputMismatchException{
					
		boolean again = true;
		
	System.out.println("===================  WELCOME TO THE STUDENT GPA CALCULATOR  =================");
	
	while(again) {
		System.out.print("\n1. Add a Course\n2. Remove a Course\n3. View All Courses"
				+ "\n4. Calculate GPA\n5. Edit Course\n6. Search Course\n7. Exit \n\nEnter your choice: ");
		
		try{
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
			modifyCourse();
			break;

		case 6:
			searchCourse();
			break;
			
		case 7:
			System.out.println("You are exiting the program...");
			again = false;
			break;
		}
		} catch (InputMismatchException e){
			System.out.println("Invalid imput. Please enter a number.");
			keyIn.nextLine();
		}
	}
	}
	
		
		public static void addCourse() {
			try{
			System.out.println("Enter the code of the course to add:(e.g., COMP248)");
			String name = keyIn.nextLine().trim().toUpperCase();
			
			System.out.println("Enter the number of credits the course is worth (0-6):");
			double credit = keyIn.nextDouble();
			keyIn.nextLine();
			

			System.out.println("Enter your recieved letter grade from the course: ");
			String letterGrade = keyIn.nextLine().trim().toUpperCase();

			Course newCourse = new Course(name,letterGrade,credit);
			
			
			manager.addCourse(newCourse);
			} catch (InvalidGradeException e){
				System.out.println(e.getMessage());
			} catch (DuplicateCourseException e){
				System.out.println(e.getMessage());
			}catch (InputMismatchException e){
				System.out.println("Invalid imput. Please enter a number.");
				keyIn.nextLine();
			}
	}
	
	
	
	private static void removeCourseOption(){
	try{
	System.out.println("Enter the code of the course to remove:(e.g., COMP248)");
	String name = keyIn.nextLine().trim().toUpperCase();

	manager.removeCourse(name);

	} catch (CourseNotFoundException e){
		System.out.println(e.getMessage());
	}
	}

	public static boolean modifyCourse() {
    try {
        System.out.println(" --- Course List --- ");
        manager.displayCourses();

        System.out.println("Enter the course name you would like to edit:");
        String toedit = keyIn.nextLine().trim().toUpperCase();

        System.out.println("What do you want to edit?");
		System.out.println("1. Course name");
        System.out.println("2. Grade");
        System.out.println("3. Credits");
        int choice = keyIn.nextInt();
        keyIn.nextLine(); // clear buffer

        switch (choice) {
			case 1:
                System.out.println("Enter the new name of the course:");
                String name = keyIn.nextLine().trim().toUpperCase();
                manager.modifyCourseName(toedit, name);
                System.out.println("Name of the class was successfully modified.");
                break;

            case 2:
                System.out.println("Enter the new grade:");
                String grade = keyIn.nextLine().trim().toUpperCase();
                manager.modifyCourseGrade(toedit, grade);
                System.out.println("Grade was successfully modified.");
                break;

            case 3:
                System.out.println("Enter the new amount of credits:");
                int credit = keyIn.nextInt();
                keyIn.nextLine();
                manager.modifyCourseCredits(toedit, credit);
                System.out.println("Credit number successfully modified.");
                break;

            default:
                System.out.println("Invalid option.");
        }

    } catch (EmptyCourseListException e) {
        System.out.println(e.getMessage());
    } catch (CourseNotFoundException e) {
        System.out.println(e.getMessage());
    } catch (InputMismatchException e){
		System.out.println("Invalid input. Please enter a number.");
		keyIn.nextLine();
	}

    return true;
}

	public static void searchCourse(){
		System.out.println("Enter the name of the course code:");

		String tosearch = keyIn.nextLine().trim().toUpperCase();

		Course crs = manager.getCourse(tosearch);

		if (crs == null)
			System.out.println("We currently do not have record of this course");

		else
			System.out.println(crs);
	}
}