package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CourseManagerTest {

    @Test
    void testAddCourse(){
        
        CourseManager cm = new CourseManager();

        cm.addCourse("COMP352", 3, 4.0);

        assertEquals(1, cm.getSize());
    }

    @Test
    void testTotalCredits() {
        CourseManager cm = new CourseManager();

        cm.addCourse("Math", 3, 4.0);
        cm.addCourse("Physics", 4, 3.0);

        assertEquals(7, cm.totalCredits());
    }

    @Test
    void testGPA() {
        CourseManager cm = new CourseManager();

        cm.addCourse("Math", 3, 4.0);    // 12 points
        cm.addCourse("Physics", 1, 2.0); // 2 points

        // GPA = 14 / 4 = 3.5
        assertEquals(3.5, cm.calculateGPA(), 0.0001);
    }

    @Test
    void testEmptyCourses() {
        CourseManager cm = new CourseManager();

        assertEquals(0, cm.totalCredits());
        assertEquals(0.0, cm.calculateGPA());
    }

    @Test
    void testDuplicateCourses() {
        CourseManager cm = new CourseManager();

        cm.addCourse("Math", 3, 4.0);
        cm.addCourse("Math", 3, 4.0);

        assertEquals(1, cm.getSize());
    }

    @Test
    void testRemoveCourse() {
        CourseManager cm = new CourseManager();

        cm.addCourse("Math", 3, 4.0);
        cm.removeCourse("Math");

        assertEquals(0, cm.getSize());
}
}