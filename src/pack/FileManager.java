package pack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static void saveToFile(List<Course> courses) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("courses.txt"))) {

        for (Course c : courses) {
            writer.write(c.getCourseName() + "," +
                         c.getCourseLetterGrade() + "," +
                         c.getCourseCredit());
            writer.newLine();
        }

        System.out.println("Data saved successfully.");

    } catch (IOException e) {
        System.out.println("Error saving file.");
    }
}

public static List<Course> loadFromFile() {
    List<Course> courses = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader("courses.txt"))) {

        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");

            String name = parts[0];
            String grade = parts[1];
            double credits = Double.parseDouble(parts[2]);

            courses.add(new Course(name, grade, credits));
        }

        System.out.println("Data loaded successfully.");

    } catch (IOException e) {
        System.out.println("Error loading file.");
    }

    return courses;
}
    
}
