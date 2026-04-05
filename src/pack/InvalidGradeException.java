package pack;

public class InvalidGradeException extends Exception{

    public InvalidGradeException (String message){
        super(message);
    }

    public InvalidGradeException (){
        super("This grad eis invalid.");
    }
}