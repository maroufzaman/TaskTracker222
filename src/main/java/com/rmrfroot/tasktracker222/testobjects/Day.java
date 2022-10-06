package com.rmrfroot.tasktracker222.testobjects;
import java.time.DayOfWeek;
import java.util.*;

public class Day {
        // declare variables
        private DayOfWeek dayOfWeek;


        private int month;

        private int year;

        //constructor
        public Day() {

                Calendar c = new GregorianCalendar();
                System.out.print(c.getTime());

        }


        // set the  day for the assigned task
        public void setDayOfWeek() {

                System.out.println("Enter the number from 1 to 7 to represent a day:");

                Scanner input = new Scanner(System.in);

                int x = input.nextInt();

                if (x >= 1 && x <= 7) {
                        dayOfWeek = DayOfWeek.of(x);
                        System.out.println(dayOfWeek.name());
                } else {
                        System.out.print("Invalid input");
                }

        }

        //set the month for assigned task
        public void setMonth() {

                System.out.println("Enter the number from 1 to 12 to represent a month:");

                Scanner input = new Scanner(System.in);

                int month = input.nextInt();

                switch (month) {

                        case 1:
                                System.out.println("January");
                                break;

                        case 2:
                                System.out.println("February");
                                break;

                        case 3:
                                System.out.println("March");
                                break;

                        case 4:
                                System.out.println("April");
                                break;

                        case 5:
                                System.out.println("May");
                                break;

                        case 6:
                                System.out.println("June");
                                break;

                        case 7:
                                System.out.println("July");
                                break;

                        case 8:
                                System.out.println("August");
                                break;

                        case 9:
                                System.out.println("September");
                                break;

                        case 10:
                                System.out.println("October");
                                break;

                        case 11:
                                System.out.println("November");
                                break;

                        case 12:
                                System.out.println("December");
                                break;

                        default:
                                System.out.println("Invalid input");
                }

        }

        //set the year for assigned task
        public void setYear() {

                System.out.println("Enter year");

                Scanner input = new Scanner(System.in);

                year = input.nextInt();
                System.out.println(year);

        }
}