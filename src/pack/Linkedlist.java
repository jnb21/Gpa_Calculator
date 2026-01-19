package pack;

/**
 * Node class representing a course and its associated grade in a linked list.
 * @author jong
 * 
 * It will contain courses added for calculation, along with their respective grades.
 * @constructor Node(Course course, double grade)
 * 
 * Linkedlist class to manage a linked list of courses and their grades.
 * 
 * @method exists(Course course): Method to check if a course already exists in the linked list.
 * @method AddCourse(Course course, double grade): Method to add a new course and its grade to the linked list.
 * @method getSize(): Method to get the number of courses in the linked list.
 */


public class Linkedlist {

    private Node head;
    private Node tail;
    private int size;

    public class Node{
    public Course course;
    public double grade;
    public Node next;

    public Node(Course course, double grade) {
        this.course = course;
        this.grade = grade;
        this.next = null;
    }
    }

    public Linkedlist() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Linkedlist(Course course, double grade) {
        Node newNode = new Node(course, grade);
        this.head = newNode;
        this.tail = newNode;
        this.size = 1;
    }

    // Additional methods for linked list operations can be added here

    // Course existence check method
    public boolean exists(Course course) {

        Node current = this.head;
        while (current != null) {
            if (current.course.equals(course)) {
                return true;
            }
            current = current.next;
        }
        return false; 
    }
    public boolean addCourse(Course course, double grade) {
        Node newNode = new Node(course, grade);

        Boolean exists = exists(course);
        if (exists) {
            return false; // Course already exists, do not add
        }
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        System.out.println("Course " + course.getName() + " added successfully.");
        size++;
        return true;
    }

    //Remove course method
    public boolean removeCourse(String coursename){
        if (head == null) {
            System.out.println("No courses to remove.");
            return false; // List is empty
        }

        Node current = head;
        Node previous = null; 

        while (current != null) {
            if (current.course.getName().equals(coursename)) {

                //If the course is the head
                if (current == head) {
                    head = current.next;
                    if (head == null) {
                        tail = null; // List is now empty
                    }
                } else{
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous; // Update tail if needed
                    }
                }

                size--;
                System.out.println("Course " + coursename + " removed successfully.");
                return true;
            }
            previous = current;
            current = current.next;
        }

        
            //Course not found
            System.out.println("Course " + coursename + " not found.");
        return false;
    }

    // To see the number of added courses
    public int getSize() {
        return size;
    }

    // To display all courses
    public void displayAllCourses() {
        if (head == null) {
            System.out.println("No courses to display.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.course.toString() + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    //Calculate GPA method
    public double calculateGPA() {

        double totalAccumulatedPoints = 0.0; double totalCredits = 0.0;

        Node current = head;
        
        while (current != null) {
            totalCredits += current.course.getCredit();
            totalAccumulatedPoints += (current.grade * current.course.getCredit());
            current = current.next;
        }
        if (totalCredits == 0) {
            return 0.0; // Avoid division by zero
        }
        return totalAccumulatedPoints / totalCredits;
}

}
