package com.example;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {

    static class Course {
        String name;
        int credits;
        double gradePoint;

        Course(String name, int credits, double gradePoint) {
            this.name = name;
            this.credits = credits;
            this.gradePoint = gradePoint;
        }

        public String getName(){
            return name;
        }
    }

    private final List<Course> courses = new ArrayList<>();

    public void addCourse(String name, int credits, double gradePoint) {
        for (Course c: courses){
            if (c.getName().equals(name))
                return;
        }
        courses.add(new Course(name, credits, gradePoint));
    }

    public void removeCourse(String name){
        courses.removeIf(c -> c.getName().equals(name));
    }

    public int getSize(){
        return courses.size();
    }

    public int totalCredits() {
        return courses.stream().mapToInt(c -> c.credits).sum();
    }

    public double calculateGPA() {
        double totalPoints = 0;
        int totalCredits = 0;

        for (Course c : courses) {
            totalPoints += c.gradePoint * c.credits;
            totalCredits += c.credits;
        }

        return totalCredits == 0 ? 0 : totalPoints / totalCredits;
    }
}