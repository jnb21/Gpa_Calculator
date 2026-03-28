package pack;

public class DuplicateCourseException extends Exception{

    public DuplicateCourseException (String message){
        super(message);
    }

    public DuplicateCourseException (){
        super("This course has already been added");
    }
}