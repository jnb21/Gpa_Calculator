package pack;

public class CourseNotFoundException extends Exception{

    public CourseNotFoundException (String message){
        super(message);
    }

    public CourseNotFoundException (){
        super("This course does not exist.");
    }
}