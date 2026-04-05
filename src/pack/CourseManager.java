package pack;

import java.util.HashMap;
import java.util.ArrayList;

public class CourseManager {

    private  ArrayList<Course> courseList = new ArrayList<>(); 
	private  HashMap<String, Course> courseMap = new HashMap<>();
    private static HashMap<String, Double> gradeScale = new HashMap<>();

    // Static initialization block - runs once when class is loaded
    static {
        gradeScale.put("A+", 4.3);
        gradeScale.put("A",  4.0);
        gradeScale.put("A-", 3.7);
        gradeScale.put("B+", 3.3);
        gradeScale.put("B",  3.0);
        gradeScale.put("B-", 2.7);
        gradeScale.put("C+", 2.3);
        gradeScale.put("C",  2.0);
        gradeScale.put("C-", 1.7);
        gradeScale.put("D+", 1.3);
        gradeScale.put("D",  1.0);
        gradeScale.put("D-", 0.7);
        gradeScale.put("F",  0.0);
    }

    //Validate Letter grade
    public boolean validate(String grade){
        return gradeScale.containsKey(grade);
    }


    //Adding courses to the courseList
    public void addCourse(Course course)throws DuplicateCourseException, InvalidGradeException{
        if (!this.validate(course.getCourseLetterGrade()))
            throw new InvalidGradeException();

        if (courseMap.containsKey(course.getCourseName()))
            throw new DuplicateCourseException();

        courseList.add(course);
        courseMap.put(course.getCourseName(), course);
    }

    //Removing the course
    public boolean removeCourse(String name) throws CourseNotFoundException {

        if (!courseMap.containsKey(name))
            throw new CourseNotFoundException();

        Course course = courseMap.get(name);

        courseList.remove(course);
        courseMap.remove(course.getCourseName());

        return true;
    }

    public void displayCourses() throws EmptyCourseListException{

        if (courseList.isEmpty())
            throw new EmptyCourseListException();
        for (Course crs: courseList)
            System.out.println(crs);
    }

    public double calculateGPA() throws EmptyCourseListException{

        if (courseList.isEmpty())
            throw new EmptyCourseListException();

        double totalPoints = 0; int totalCredits = 0;

        for (Course crs: courseList){
            totalPoints += (gradeScale.get(crs.getCourseLetterGrade()) * crs.getCourseCredit());
            totalCredits += crs.getCourseCredit();
        }

        return totalPoints/(double)totalCredits;
    }

    public boolean checkDuplicates(Course course){
        return courseMap.containsKey(course.getCourseName());
    }

    public Course getCourse(String coursename){
        return courseMap.get(coursename);

    }

// 2 modifications (garde and credits)
    public void modifyCourseGrade(String courseName, String newGrade)
        throws CourseNotFoundException {

    if (!courseMap.containsKey(courseName)) {
        throw new CourseNotFoundException();
    }

    Course c = courseMap.get(courseName);
    c.setLetterGrade(newGrade);
}

public void modifyCourseCredits(String courseName, int newCredits)
        throws CourseNotFoundException {

    if (!courseMap.containsKey(courseName)) {
        throw new CourseNotFoundException();
    }

    Course c = courseMap.get(courseName);
    c.setCourseCredits(newCredits);
}

}
