package com.example.database;


import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.model.Course;

public class CourseRepository {

    public void addCourse(Course course) {
        String sql = "INSERT INTO courses (name, grade, credits) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getCourseLetterGrade());
            stmt.setDouble(3, course.getCourseCredit());

            stmt.executeUpdate();
            System.out.println("Course inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
