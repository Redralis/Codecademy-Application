package test;

public class NumericRangeTools {

    /**
     * @desc Validates if the input is within range of 0-100%
     * 
     * @subcontract value within valid range {
     *   @requires 0 <= percentage <= 100;
     *   @ensures \result = true;
     * }
     * 
     * @subcontract value out of range low {
     *   @requires percentage < 0;
     *   @ensures \result = false;
     * }
     * 
     * @subcontract value out of range high {
     *   @requires percentage > 100;
     *   @signals \result = false;
     * }
     * 
     */
    public static String isValidPercentage(int percentage) {
        if (percentage < 0) {
            return "false";
        } else if (percentage > 100) {
            return "false";
        }
        return "true";
    }    
}
