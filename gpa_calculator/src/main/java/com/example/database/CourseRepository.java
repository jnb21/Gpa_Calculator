package com.example.database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public void removeCourse(String name){
        String sql = "DELETE FROM courses WHERE name = ?";

        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, name);

            stmt.executeUpdate();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void viewCourses() {

    String sql = "SELECT * FROM courses";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {

            int id = rs.getInt("id");
            String name = rs.getString("name");
            String grade = rs.getString("grade");
            double credits = rs.getDouble("credits");

            System.out.println(id + " | " + name + " | " + credits + " | " + grade);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    public void deleteAll() {

    String sql = "DELETE FROM courses";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        int rows = stmt.executeUpdate();

        System.out.println("Deleted rows: " + rows);

    } catch (Exception e) {
        System.out.println("Error deleting courses:");
        e.printStackTrace();
    }
}

}
