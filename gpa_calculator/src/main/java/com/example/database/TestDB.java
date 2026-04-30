package com.example.database;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("Connected to database successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}