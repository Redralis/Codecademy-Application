package test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RatingToolsTest {

    /**
     * @desc Validates if the input is within range of 1-10
     * 
     * @subcontract value within valid range {
     *   @requires 1 <= value <= 10;
     *   @ensures \result = true;
     * }
     */
    @Test
    public void testRatingToolsRequires5Dot2EnsuresTrue() {
        //Arrange
        double rating = 5.2;

        //Act
        String result = RatingTools.isValidRating(rating);

        //Assert
        assertEquals("true", result);
    }

    /** 
     * @subcontract value out of range low {
     *   @requires value < 1;
     *   @ensures \result = false;
     * }
     */ 
    @Test
    public void testRatingToolsRequires0Dot9EnsuresFalse() {
        //Arrange
        double rating = 0.9;

        //Act
        String result = RatingTools.isValidRating(rating);

        //Assert
        assertEquals("false", result);
    }

     /** @subcontract value out of range high {
     *   @requires value > 10;
     *   @signals \result = false;
     * }
     * 
     */
    @Test
    public void testNumericRangeToolsRequires10Dot1EnsuresFalse() {
        //Arrange
        double rating = 10.1;

        //Act
        String result = RatingTools.isValidRating(rating);

        //Assert
        assertEquals("false", result);
    }

}