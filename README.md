# Student GPA Calculator – Java

The Student GPA Calculator is a Java-based, menu-driven console application that allows users to manage academic courses and calculate their Grade Point Average (GPA). The application applies object-oriented programming principles and simulates a basic academic grading system.

Users can add courses by entering the course name, credit value, and letter grade, remove previously added courses, view all registered courses, and calculate their GPA. Only courses entered by the user are included in the GPA calculation.

The GPA is calculated using a weighted average based on course credits. Letter grades are converted into grade points using the Concordia University grading scale (e.g., A+ = 4.30, A = 4.00, B+ = 3.30).

The application includes input validation and custom exceptions to handle errors such as duplicate courses, invalid grades, negative credit values, or attempting to calculate GPA without any registered courses.

## Project Structure
- Course: Represents a course (name, credits, grade, grade points)
- CourseManager: Manages course storage, validation, and GPA calculation
- Main: Handles user interaction and menu navigation
- Custom Exceptions: Handle invalid input and logical errors

## Concepts Used
- Object-Oriented Programming
- List and HashMap
- Console-based user interface
- Weighted average calculations

## Future Improvements
- Save and load data from file
- Support multiple students
- Graphical user interface (GUI)
