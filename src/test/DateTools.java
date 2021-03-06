package test;

public class DateTools {
    /**
     * @desc Validates if a given date in the form of day, month and year is valid.
     * 
     * @subcontract 31 days in month {
     * @requires (month == 1 || month == 3 || month == 5 || month == 7 ||
     *           month == 8 || month == 10 || month == 12) && 1 <= day <= 31;
     * @ensures \result = true;
     *          }
     * 
     * @subcontract 30 days in month {
     * @requires (month == 4 || month == 6 || month == 9 || month == 11) &&
     *           1 <= day <= 30;
     * @ensures \result = true;
     *          }
     * 
     * @subcontract 29 days in month {
     * @requires month == 2 && 1 <= day <= 29 &&
     *           (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
     * @ensures \result = true;
     *          }
     * 
     * @subcontract 28 days in month {
     * @requires month == 2 && 1 <= day <= 28 &&
     *           (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0));
     * @ensures \result = true;
     *          }
     * @subcontract 14 months in a year {
     *  @requires month > 12;
     * @ensures \result = false;
     *          }
     *
     * @subcontract year is 11111 {
     *  @requires year > 9999;
     * @ensures \result = false;
     *          }
     *
     * @subcontract all other cases {
     * @requires no other accepting precondition;
     * @ensures \result = false;
     *          }
     * 
     */
    public static String validateDate(int day, int month, int year) {
        if (day > 31) {
            return "false";
        } else if (month > 12) {
            return "false";
        } else if (year > 9999) {
            return "false";
        } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
                || month == 12 && day >= 1 && day <= 31) {
            return "true";
        } else if (month == 4 || month == 6 || month == 9 || month == 11 && day >= 1 || day <= 30) {
            return "true";
        } else if (month == 2 && day >= 1 || day <= 29 && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) {
            return "true";
        } else if (month == 2 && day >= 1 || day <= 28 && (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0))) {
            return "true";
        } else {
            return "false";
        }

    }
}
