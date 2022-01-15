package test;

public class RatingTools {

    /**
     * @desc Validates if the input is within range of 1-10
     * 
     * @subcontract value within valid range {
     *   @requires 1 <= value <= 10;
     *   @ensures \result = true;
     * }
     * 
     * @subcontract value out of range low {
     *   @requires value < 1;
     *   @ensures \result = false;
     * }
     * 
     * @subcontract value out of range high {
     *   @requires value > 10;
     *   @signals \result = false;
     * }
     * 
     */
    public static String isValidRating(double rating) {
        if (rating < 1) {
            return "false";
        } else if (rating > 10) {
            return "false";
        }
        return "true";
    }    
}
