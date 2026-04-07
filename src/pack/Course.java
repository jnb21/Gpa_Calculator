package pack;

public class Course{

    private String name;
    private double credit;
    private String letterGrade;

    public Course(String name, String letterGrade, double credit) {
        this.name = name;
        this.credit = credit;
        this.letterGrade = letterGrade;
    }

	public String getCourseName() {
        return name;
    }
    
    public void setCourseName(String newName){
        this.name = newName;
    }


    public void setLetterGrade(String letterGrade){
        this.letterGrade = letterGrade;
    }


    public double getCourseCredit() {
        return credit;
    }

    public void setCourseCredits(double credit){
        this.credit = credit;
    }

    public String getCourseLetterGrade(){
        return letterGrade;
    }

    public String toString() {
        return "\nCourse Name: " + name + "\nGrade: "+ letterGrade+ "\nCredits: " + credit ;
    }   

    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) {return false;}
        if (this == other) return true;

        Course otherCourse = (Course) other;
        return this.name.equals(otherCourse.name) && this.credit == otherCourse.credit;
    }
}
