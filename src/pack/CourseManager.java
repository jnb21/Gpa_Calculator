package pack;

import java.util.HashMap;
import java.util.ArrayList;

public class CourseManager {

    private static ArrayList<Course> courseList = new ArrayList<>(); 
	private static HashMap<String, Course> courseMap = new HashMap<>();
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


    //Adding courses to the courseList
    public void addCourse(Course course){
        courseList.add(course);
        courseMap.put(course.getCourseName(), course);
    }

    //Removing the course
    public void removeCourse(Course course){
        courseList.remove(course);
        courseMap.remove(course.getCourseName());
    }

    public void displayCourses(){
        for (Course crs: courseList)
            System.out.println(crs);
    }

    public double calculateGPA(){

        if (courseList.isEmpty())
            return -1;

        double totalPoints = 0; int totalCredits = 0;

        for (Course crs: courseList){
            totalPoints += (gradeScale.get(crs.getLetterGrade()) * crs.getCredit());
            totalCredits += crs.getCredit();
        }

        return totalPoints/(double)totalCredits;
    }

    public boolean checkDuplicates(Course course){
        return courseMap.containsKey(course.getCourseName());
    }

    public Course getCourse(String coursename){
        return courseMap.get(coursename);
    }
}
