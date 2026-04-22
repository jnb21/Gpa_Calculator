package pack;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CourseManager {

    private  ArrayList<Course> courseList = new ArrayList<>();
	private  HashMap<String, Course> courseMap = new HashMap<>();
    private static HashMap<String, Double> gradeScale = new HashMap<>();

    private static int numberOfCourses = 0;
    private static  double totalPoints = 0, totalCredits = 0;

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


    public int getnumberOfCourses(){

        if (numberOfCourses == 0)
            System.out.println("\nYou have not enrolled in any class yet.");
        return numberOfCourses;
    }

    public double getTotalCredits(){
        if (totalCredits == 0)
            System.out.println("\nYou have not earned any credits yet");
        return totalCredits;
    }

    public double getHighestGrade() throws EmptyCourseListException{

    if (courseList.isEmpty())
        throw new EmptyCourseListException();

    double max = gradeScale.get("F");

    for (Course c : courseList) {
        double number = gradeScale.get(c.getCourseLetterGrade());

        if (number > max)
            max = number;
    }


    System.out.println("Your highest grade is: "+ max);
    System.out.println("You have achived that grade in the following couses:");

        for (Course c: courseList){
            if (max == gradeScale.get(c.getCourseLetterGrade()))
                System.out.println(c);
        }

    return max;
    }

    

    public double getEarnedCredits(){

        double sum = 0.0;

        for (Course c: courseList){
            if(c.getCourseLetterGrade().equals("F"))
                sum += c.getCourseCredit();
        }

        return sum;
    }

    public double getLowestGrade() throws EmptyCourseListException{

        if (courseList.isEmpty())
            throw new EmptyCourseListException();

        double min = gradeScale.get("A+");

        for (Course c : courseList) {
        double number = gradeScale.get(c.getCourseLetterGrade());

        if (number < min)
            min = number;
        }

        System.out.println("Your lowest grade is: "+ min);
        System.out.println("You have achived that grade in the following couses:");

        for (Course c: courseList){
            if (min == gradeScale.get(c.getCourseLetterGrade()))
                System.out.println(c);
        }

        return min;
    }


    //Validate Letter grade
    public boolean validate(String grade){
        return gradeScale.containsKey(grade);
    }

    //GET COURSE
    public Course getCourse(String coursename){
        return courseMap.get(coursename);

    }


    //ADD COURSE

    public void addCourse(Course course)throws DuplicateCourseException, InvalidGradeException{
        if (!this.validate(course.getCourseLetterGrade()))
            throw new InvalidGradeException();

        if (courseMap.containsKey(course.getCourseName()))
            throw new DuplicateCourseException();

        courseList.add(course);
        courseMap.put(course.getCourseName(), course);

        numberOfCourses++;
    }


    //REMOVE COURSE
    public boolean removeCourse(String name) throws CourseNotFoundException {

        if (!courseMap.containsKey(name))
            throw new CourseNotFoundException();

        Course course = courseMap.get(name);

        courseList.remove(course);
        courseMap.remove(course.getCourseName());

        return true;
    }

    //DISPLAY COURSES
    public void displayCourses() throws EmptyCourseListException{

        if (courseList.isEmpty())
            throw new EmptyCourseListException();
        for (Course crs: courseList)
            System.out.println(crs);
    }

    //CALCULATE GPA
    public double calculateGPA() throws EmptyCourseListException{

        if (courseList.isEmpty())
            throw new EmptyCourseListException();

        for (Course crs: courseList){
            totalPoints += (gradeScale.get(crs.getCourseLetterGrade()) * crs.getCourseCredit());
            totalCredits += crs.getCourseCredit();
        }

        return totalPoints/totalCredits;
    }

    //CHECK DUPLICATES
        public boolean checkDuplicates(Course course){
        return courseMap.containsKey(course.getCourseName());
    }

    // MODIFY COURSES (ALL 3 METHODS)
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

            public void modifyCourseName(String courseName, String newName)
            throws CourseNotFoundException{

            if (!courseMap.containsKey(courseName)){
            throw new CourseNotFoundException();
            }

            Course c = courseMap.get(courseName);
            c.setCourseName(newName);
        }

        public List<Course> getAllCourses() {
        return courseList;
        }

        //LOADING COURSES FROM FILES
        public void loadCourses(List<Course> courses) {
            courseList.clear();
            courseMap.clear();

        for (Course c : courses) {
            courseList.add(c);
            courseMap.put(c.getCourseName(), c);
        }
    }

}
