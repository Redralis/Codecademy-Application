package test;

import static org.junit.Assert.*;
import org.junit.Test;

public class DateToolsTest {

        /**
         * @desc Validates is a given date in the form of day, month and year is valid.
         * 
         * @subcontract 31 days in month {
         * @requires (month == 1 || month == 3 || month == 5 || month == 7 ||
         *           month == 8 || month == 10 || month == 12) && 1 <= day <= 31;
         * @ensures \result = true;
         */
        @Test
        public void testDateToolsRequires31EnsuresTrue() {
                //Arrange
                int days = 31;
                int month = 3;
                int year = 2022;

                //Act
                String result = DateTools.validateDate(days, month, year);

                //Assert
                assertEquals("true", result);
        }

        /*
         * }
         * 
         * @subcontract 30 days in month {
         * 
         * @requires (month == 4 || month == 6 || month == 9 || month == 11) &&
         * 1 <= day <= 30;
         * 
         * @ensures \result = true;
         */
        @Test
        public void testDateToolsRequires30DaysEnsuresTrue() {
                // Arrange
                int days = 30;
                int month = 3;
                int year = 2022;

                // Act
                String result = DateTools.validateDate(days, month, year);

                // Assert
                assertEquals("true", result);
        }

        /*
         * }
         * 
         * @subcontract 29 days in month {
         * 
         * @requires month == 2 && 1 <= day <= 29 &&
         * (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
         * 
         * @ensures \result = true;
         */
        @Test
        public void testDateToolsRequires29daysEnsuresTrue() {
                // Arrange
                int days = 29;
                int month = 3;
                int year = 2022;

                // Act
                String result = DateTools.validateDate(days, month, year);

                // Assert
                assertEquals("true", result);
        }

        /*
         * }
         * 
         * @subcontract 28 days in month {
         *
         * @requires month == 2 && 1 <= day <= 28 &&
         * (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0));
         *
         * @ensures \result = true;
         */
        @Test
        public void testDateToolsRequires28DaysInMonthEnsuresTrue() {
                // Arrange
                int days = 28;
                int month = 3;
                int year = 2022;

                // Act
                String result = DateTools.validateDate(days, month, year);

                // Assert
                assertEquals("true", result);
        }

        /*
         * }
         *  @subcontract 14 months in a year {
         * @requires month > 12;
         *
         * @ensures \result = false;
         *
         **/
        @Test
        public void testDateToolsRequiresMoreThan12EnsuresFalse() {
                // Arrange
                int days = 30;
                int month = 14;
                int year = 2022;

                // Act
                String result = DateTools.validateDate(days, month, year);

                // Assert
                assertEquals("false", result);
        }

        /*
         * }
         *  @subcontract 14 months in a year {
         * @requires month > 12;
         *
         * @ensures \result = false;
         *
         **/
        @Test
        public void testDateToolsRequiresMoreThan9999EnsuresFalse() {
                // Arrange
                int days = 30;
                int month = 9;
                int year = 11111;

                // Act
                String result = DateTools.validateDate(days, month, year);

                // Assert
                assertEquals("false", result);
        }

        /*
         *}
         * @subcontract all other cases {
         * 
         * @requires no other accepting precondition;
         * 
         * @ensures \result = false;
         */
        @Test
        public void testDateToolsRequiresNoPreconditionEnsuresFalse() {
                // Arrange
                int days = 35;
                int month = 3;
                int year = 2022;

                // Act
                String result = DateTools.validateDate(days, month, year);

                // Assert
                assertEquals("false", result);
        }

        /*

         */
        
}