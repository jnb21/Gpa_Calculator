package pack;

import java.util.HashMap;
/**
 * @author Jordan Bikong
 * 
 * CourseManager class to manage course grades and their corresponding GPA values.
 * It contains a HashMap that maps letter grades to their respective GPA values.
 * 
 * @constructor CourseManager()
 * @method convertLetterGradeToGpa(String letterGrade): Static method to convert a letter grade to its GPA value.
 */

public class CourseManager {


	private static HashMap<String, Double> GRADE_MAP = new HashMap<>();

	// Static initialization block - runs once when class is loaded
    static {
        GRADE_MAP.put("A+", 4.3);
        GRADE_MAP.put("A",  4.0);
        GRADE_MAP.put("A-", 3.7);
        GRADE_MAP.put("B+", 3.3);
        GRADE_MAP.put("B",  3.0);
        GRADE_MAP.put("B-", 2.7);
        GRADE_MAP.put("C+", 2.3);
        GRADE_MAP.put("C",  2.0);
        GRADE_MAP.put("C-", 1.7);
        GRADE_MAP.put("D+", 1.3);
        GRADE_MAP.put("D",  1.0);
        GRADE_MAP.put("D-", 0.7);
        GRADE_MAP.put("F",  0.0);
    }

    /**
     * Converts a letter grade to its GPA value.
     * Handles whitespace and case insensitivity.
     * 
     * @param letterGrade the letter grade (e.g., "A", "B+", "C-")
     * @return the GPA value, or null if invalid grade
     */
    public static Double convertLetterGradeToGpa(String letterGrade) {
    	
        if (letterGrade == null || letterGrade.trim().isEmpty()) return null;
        
     
        letterGrade = letterGrade.trim().toUpperCase();
        
        
        return GRADE_MAP.get(letterGrade);
    }
}
