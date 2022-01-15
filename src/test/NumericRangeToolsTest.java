package test;

import static org.junit.Assert.*;
import org.junit.Test;

public class NumericRangeToolsTest {

    /**
     * @desc Validates if the input is within range of 0-100%
     * 
     * @subcontract value within valid range {
     *   @requires 0 <= percentage <= 100;
     *   @ensures \result = true;
     * }
     */
    @Test
    public void testNumericRangeToolsRequires50EnsuresTrue() {
        //Arrange
        int percentage = 50;

        //Act
        String result = NumericRangeTools.isValidPercentage(percentage);

        //Assert
        assertEquals("true", result);
    }

    /** 
     * @subcontract value out of range low {
     *   @requires percentage < 0;
     *   @ensures \result = false;
     * }
     */ 
    @Test
    public void testNumericRangeToolsRequiresMinus1EnsuresFalse() {
        //Arrange
        int percentage = -1;

        //Act
        String result = NumericRangeTools.isValidPercentage(percentage);

        //Assert
        assertEquals("false", result);
    }

     /** @subcontract value out of range high {
     *   @requires percentage > 100;
     *   @signals \result = false;
     * }
     * 
     */
    @Test
    public void testNumericRangeToolsRequires101EnsuresFalse() {
        //Arrange
        int percentage = 101;

        //Act
        String result = NumericRangeTools.isValidPercentage(percentage);

        //Assert
        assertEquals("false", result);
    }

}