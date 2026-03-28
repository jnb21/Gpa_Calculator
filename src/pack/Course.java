package pack;

public class Course{

    private String name;
    private double credit;
    private String letterGrade;

    public Course(String name, Sting letterGrade, double credit) {
        this.name = name;
        this.credit = credit;
        this.letterGrade = letterGrade;
    }

	public String getCourseName() {
        return name;
    }

    public double getCredit() {
        return credit;
    }

    public void getLetterGrade(){
        return letterGrade;
    }

    public String toString() {
        return "\nCourse Name: " + name + "\nGrade: +"letterGrade+"\nCredits: " + credit+"\n";
    }   

    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) {return false;}
        if (this == other) return true;

        Course otherCourse = (Course) other;
        return this.name.equals(otherCourse.name) && this.credit == otherCourse.credit;
    }
}
