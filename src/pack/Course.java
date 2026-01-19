package pack;

public class Course{

    private String name;
    private double credit;

    public Course(String name, double credit) {
        this.name = name;
        this.credit = credit;
    }

	public String getName() {
        return name;
    }

    public double getCredit() {
        return credit;
    }

    public String toString() {
        return "Course Name: " + name + ", Credits: " + credit;
    }   

    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) {return false;}
        if (this == other) return true;

        Course otherCourse = (Course) other;
        return this.name.equals(otherCourse.name) && this.credit == otherCourse.credit;
    }
}
