package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CourseManagerTest {

    @Test
    void testAddCourse() throws Exception {
        CourseManager cm = new CourseManager();

        Course crs = new Course("Programming", "B+", 3.0);
        cm.addCourse(crs);

        assertEquals(1, cm.getCourseListSize());
    }

    @Test
    void testTotalCredits() throws Exception {
        CourseManager cm = new CourseManager();

        cm.addCourse(new Course("Math", "A", 4.0));
        cm.addCourse(new Course("Physics", "B", 3.0));

        assertEquals(7.0, cm.getTotalCredits(), 0.0001);
    }

    @Test
    void testGPA() throws Exception {
        CourseManager cm = new CourseManager();

        cm.addCourse(new Course("Math", "A", 4.0));      // 4.0 * 4 = 16
        cm.addCourse(new Course("Physics", "B", 3.0));   // 3.0 * 3 = 9

        // Total = 25 / 7 = 3.5714
        assertEquals(25.0 / 7.0, cm.calculateGPA(), 0.0001);
    }

    @Test
    void testEmptyCourses() throws Exception {
        CourseManager cm = new CourseManager();

        assertEquals(0.0, cm.getTotalCredits(), 0.0001);
        assertThrows(EmptyCourseListException.class, () -> cm.calculateGPA());
        assertEquals(0, cm.getCourseListSize());
    }

    @Test
    void testDuplicateCourses() throws Exception {
        CourseManager cm = new CourseManager();

        cm.addCourse(new Course("Math", "A", 4.0));

        assertThrows(DuplicateCourseException.class, () -> {
            cm.addCourse(new Course("Math", "A", 4.0));
        });
    }

    @Test
    void testRemoveCourse() throws Exception {
        CourseManager cm = new CourseManager();

        cm.addCourse(new Course("Physics", "B", 3.0));
        cm.removeCourse("Physics");

        assertEquals(0, cm.getCourseListSize());
    }
}