package test;

import static org.junit.Assert.*;
import org.junit.Test;

public class PostalCodeTest {

    /**
     * @desc Formats the input postal code to a uniform output in the form
     * nnnn<space>MM, where nnnn is numeric and > 999 and MM are 2 capital letters.
     * Spaces before and after the input string are trimmed.
     * 
     * @subcontract null postalCode {
     *   @requires postalCode == null;
     *   @signals (NullPointerException) postalCode == null;
     */
    @Test(expected = NullPointerException.class)
    public void testPostalCodeRequiresNullSignalsNullPointerException() {
            //Arrange
            String postalCode = null;

            //Act
            PostalCode.isValidPostalCode(postalCode);
    }

    /* }
     * 
     * @subcontract valid postalCode {
     *   @requires Integer.valueOf(postalCode.trim().substring(0, 4)) > 999 &&
     *             Integer.valueOf(postalCode.trim().substring(0, 4)) <= 9999 &&
     *             postalCode.trim().substring(4).trim().length == 2 &&
     *             'A' <= postalCode.trim().substring(4).trim().toUpperCase().charAt(0) <= 'Z' &&
     *             'A' <= postalCode.trim().substring(4).trim().toUpperCase().charAt(0) <= 'Z';
     *   @ensures \result = postalCode.trim().substring(0, 4) + " " +
     *                  postalCode.trim().substring(4).trim().toUpperCase()
     */
    @Test
    public void testPostalCodeRequiresFourNumbersOneSpaceTwoLettersEnsuresTrue() {
            //Arrange
            String postalCode = "3333 ET";

            //Act
            String result = PostalCode.isValidPostalCode(postalCode);

            //Assert
            assertEquals(postalCode.trim().substring(0, 4) + " " + postalCode.trim().substring(4).trim().toUpperCase(), result);
    }

    /* }
     *  
     * @subcontract invalid postalCode {
     *   @requires no other valid precondition;
     *   @signals (IllegalArgumentException);
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPostalCodeRequiresThreeNumbersOneSpaceTwoLettersEnsuresFalse() {
            //Arrange
            String postalCode = "333 KK";

            //Act
            PostalCode.isValidPostalCode(postalCode);
    }
    
    /*
     *  
     */
    
}
