The Student GPA Calculator is a Java-based, menu-driven console application that allows users to manage academic courses and calculate their Grade Point Average (GPA). The program is designed to apply object-oriented programming principles and simulate a basic academic grading system.

Users can add courses by entering the course name, credit value, and letter grade, remove previously added courses, view all registered courses, and calculate their GPA. Only courses that have been added by the user are included in the GPA calculation.

The GPA is calculated using a weighted average based on course credits. Letter grades are converted into grade points using the official Concordia University grading scale (for example, A+ = 4.30, A = 4.00, B+ = 3.30, etc.).

The application includes input validation and custom exceptions to handle common errors such as duplicate courses, invalid grades, negative credit values, or attempting to calculate a GPA without any registered courses.

The program is structured using multiple classes to ensure clean separation of responsibilities:
	•	Course: represents an academic course with its name, credits, letter grade, and grade points
	•	CourseManager: manages course storage, validation, and GPA calculation
	•	Main: handles user interaction and menu navigation
	•	Custom Exceptions: handle invalid input and logical errors

This project demonstrates practical Java programming skills, including object-oriented design, use of collections (ArrayList and HashMap), exception handling, and console-based user interaction. It can be extended in the future to include file storage, multiple students, or a graphical user interface.
