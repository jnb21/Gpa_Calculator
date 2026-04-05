package pack;

public class InvalidGradeException extends Exception{

    public InvalidGradeException (String message){
        super(message);
    }

    public InvalidGradeException (){
<<<<<<< HEAD
        super("The grade entered is invalid.");
=======
        super("This grad eis invalid.");
>>>>>>> version2
    }
}