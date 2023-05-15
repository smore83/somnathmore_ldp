/*
Problem Statement:
    Gruber Healthcare has different types of forms for their customer, one of which is a know your customer form ( KYC ) which has to be filled annually.
    Each form has a date which signifies the date the form was filled called the form date. Due to government regulations the KYC form can only be filled within + or - 30 days of the signup anniversary of a customer.
    When filling it up, you have to provide the form date. If you are past the +-30 day anniversary then you can back-date it so that it falls in the +-30-day window. When filling it up you cannot use a future date for the form date.

    For Example, assuming today is 4 Apr 2017 and I had signed up on 1st Mar 2014, my window for KYC submission this year would be 30 Jan 2017 to 31 Mar 2017. Since it is already 4th Apr - I would have to back-date the KYC to a date in this range.
    Note: The KYC form can be filled only for the closest anniversary in the past or within 30 days range in future.
    Anniversary refers to same day and month every year. If your birthday is 01-02-1992 -then your first anniversary will be 01-02-1993, the 2nd will be 01-02-1994 and so on. 01-02-1992 is not an anniversary.
    Given the signup date and the current date, provide the allowable date range for the form date.

    Input - First line is an integer n as the number of inputs to be passed. Next, n lines are n input for the program in the format dd-mm-yyyy dd-mm-yyyy
    Each line has two dates separated by space where the first date in signup date and the second date is the current date.
    Output - Range of dates for KYC form in format dd-mm-yyyy dd-mm-yyyy

    Test Input:
    5
    16-07-1998 27-06-2017
    04-02-2016 04-04-2017
    04-05-2017 04-04-2017
    04-04-2015 04-04-2016
    04-04-2015 15-03-2016

    Test output:
    16-06-2017 27-06-2017
    05-01-2017 06-03-2017
    No range
    05-03-2016 04-04-2016
    05-03-2016 15-03-2016

 */
//a. Read the signup date and the current date from the input.
//        b. Extract the day, month and year values from the signup date and current date.
//        c. Calculate the anniversary date for the signup date for the current year.
//        d. Calculate the range for KYC form date as follows:
//        i. If the current date is before the anniversary date, then the allowable date range is from the anniversary date of the previous year to the current date.
//        ii. If the current date is after the anniversary date but within 30 days of the anniversary date, then the allowable date range is from the anniversary date to 30 days after the anniversary date.
//        iii. If the current date is after 30 days of the anniversary date, then the allowable date range is from 30 days before the anniversary date to 30 days after the anniversary date.
//        e. Print the allowable date range for KYC form in the format dd-mm-yyyy dd-mm-yyyy.
//        You can write a Java program to implement this algorithm.

package Java_Assignment.assignment4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class KYCForm {
    private Date signUpDate, currentDate;
    private String stringStartDate, stringEndDate;
    private Date startDate, endDate;

    // Method rangeKycDate to find the range of date on which user can fill the form. Complexity: Time: O(1), Space: O(1)
    public void rangeKycDate(String inputSignUpDate, String inputCurrentDate) {
        try {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
            signUpDate = dateFormatter.parse(inputSignUpDate);
            currentDate = dateFormatter.parse(inputCurrentDate);

            if (signUpDate.after(currentDate)) {
                System.out.println("No range");//okk
            } else {
                startDate = signUpDate;
                startDate.setYear(currentDate.getYear());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(startDate);
                System.out.println("start"+startDate);
                calendar.add(Calendar.DATE, -30);
                startDate = calendar.getTime();
                System.out.println(startDate+"calender"+Calendar.DATE);
                calendar.add(Calendar.DATE, 60);
                System.out.println("after"+startDate+"cal"+Calendar.DATE);
                endDate = calendar.getTime();
                System.out.println("enddate"+endDate);
                System.out.println("cur"+currentDate+"end "+endDate);
                if (endDate.after(currentDate)) {
                    endDate = currentDate;
                }
                stringStartDate = dateFormatter.format(startDate);
                stringEndDate = dateFormatter.format(endDate);
                System.out.println(stringStartDate + " " + stringEndDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        KYCForm anniversaryForm = new KYCForm();
        anniversaryForm.rangeKycDate("16-07-1998", "27-06-2017");
//        anniversaryForm.rangeKycDate("04-02-2016", "04-04-2017");
//        anniversaryForm.rangeKycDate("04-05-2017", "04-04-2017");
//        anniversaryForm.rangeKycDate("04-04-2015", "04-04-2016");
//        anniversaryForm.rangeKycDate("04-04-2015", "15-03-2016");
    }
}