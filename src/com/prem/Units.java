package com.prem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Units {
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";


    private final

    List<Unit> unitList = new ArrayList<>();
    int unitsToRepeat=0;

    //Constructor
    public Units() {
        try {
            if(loadFromDB())
                System.out.println("Data correctly imported from DB");
            else
                System.out.println("Data NOT correctly imported from DB");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //Used in constructor to load data from DB
    boolean loadFromDB() throws ParseException {
        //  Load all unit from DateBase

        //Test data preparation
        Calendar rep_date = new GregorianCalendar(2021,Calendar.DECEMBER,28);

        Unit    unit1 = new Unit(1, true, "ESP-robić", "", "",
                "hacer", "hago", "haces", "hace", "hacemos", "hacéis", "hacen",
                11, rep_date, 2.8);
        unitList.add(unit1);

        Unit    unit2 = new Unit(2, false, "dwa", "dwa_1", "",
                "two", "", "", "", "", "", "",
                11, rep_date, 2.8);
        unitList.add(unit2);

        rep_date = new GregorianCalendar(2021,Calendar.DECEMBER,27);

        Unit    unit3 = new Unit(3, false, "trzy", "trzy_1", "trzy_2",
                "three", "", "", "", "", "", "",
                11, rep_date, 2.8);
        unitList.add(unit3);

        rep_date = new GregorianCalendar(2022,Calendar.MARCH,1);

        Unit    unit4 = new Unit(4, false, "cztery", "", "",
                "four", "", "", "", "", "", "",
                1, rep_date, 2.3);
        unitList.add(unit4);

        Unit    unit5 = new Unit(5, false, "pięć", "", "",
                "five", "", "", "", "", "", "",
                1, rep_date, 2.3);
        unitList.add(unit5);

        Unit    unit6 = new Unit(6, false, "sześć", "", "",
                "six", "", "", "", "", "", "",
                1, rep_date, 1.3);
        unitList.add(unit6);

        Unit    unit7 = new Unit(7, false, "siedem", "", "",
                "seven", "", "", "", "", "", "",
                1, rep_date, 1.3);
        unitList.add(unit7);

        Unit    unit8 = new Unit(8, false, "osiem", "", "",
                "eight", "", "", "", "", "", "",
                1, rep_date, 1.3);
        unitList.add(unit8);

        Unit    unit9 = new Unit(9, false, "dziewięć", "", "",
                "nine", "", "", "", "", "", "",
                1, rep_date, 1.3);
        unitList.add(unit9);

        Unit    unit10 = new Unit(10, false, "dziesięć", "", "",
                "10", "", "", "", "", "", "",
                1, rep_date, 1.3);
        unitList.add(unit10);

        return true;
    }

    //Option 0 - display all units
    void displayUnits() {
        System.out.println("DisplayBegin");
        for (Unit unit: unitList){
            System.out.println("id="+unit.getId() +
                    " q="+unit.getQuestion()+
                    " a="+unit.getAnswer()+
                    " interval="+unit.getInterval()+
                    " rep_date="+unit.getRepetitionDate().getTime()+
                    " EF="+unit.getEasinessFactor()
            );
        }
        System.out.println("DisplayFinish");
    }

    //Option 1 - repeat units
    void repeatUnits() {
        //Set the number of units to repeat
        unitsToRepeat=unitsToRepeat();
        System.out.println("Number units to repeat:"+ ANSI_PURPLE + unitsToRepeat + ANSI_RESET);

        //Random unit to repeat
        while (unitsToRepeat>0){
            int selected = (int)(Math.random() * unitsToRepeat)+1;
            //System.out.println("Selected: " + selected);
            displayUnit(selected);
            unitsToRepeat=unitsToRepeat-1;
        }

    }

    //Option 1 - Count the number of units which have to be repeated today
    int unitsToRepeat() {

        int uToR = 0;

        //Today in string format
        Calendar today= new GregorianCalendar();

        //Unit next repetition date
        Calendar nextRepDate;

        for (Unit unit: unitList) {
            nextRepDate = unit.getRepetitionDate();
            if (today.after(nextRepDate) || today.equals(nextRepDate)) {
                uToR++;
            }
        }

        return uToR;
    }


    //Option 1
    void displayUnit(int unitToDisplay){

        int uToR = 0;
        Unit selected=null;

        //Today in string format
        Calendar today= new GregorianCalendar();

        //Unit next repetition date
        Calendar nextRepDate;

        //Display question to repeat
        for (Unit unit: unitList) {
            nextRepDate = unit.getRepetitionDate();
            if (today.after(nextRepDate) || today.equals(nextRepDate)) {
                uToR++;
                if (uToR>=unitToDisplay){
                    System.out.println();
                    System.out.println("==================================================");
                    System.out.println("id="+unit.getId());
                    System.out.println("q="+ANSI_YELLOW+unit.getQuestion()+ANSI_RESET);
                    if (!unit.getQuestion1().equals(""))
                        System.out.println("q="+ANSI_YELLOW+unit.getQuestion1()+ANSI_RESET);
                    if (!unit.getQuestion2().equals(""))
                        System.out.println("q="+ANSI_YELLOW+unit.getQuestion2()+ANSI_RESET);
                    if(unit.isVerbIrregular)
                        System.out.println(ANSI_YELLOW+"Irregular verb"+ANSI_RESET);
                    System.out.println("--------------------------------------------------");
//                            " a="+unit.getAnswer()+
//                            " lst="+dateFormat.format(unit.getLast_rep_date())+
//                            " nxt="+dateFormat.format(unit.getNext_rep_date())+
//                            " ef="+unit.getEasiness_factor()
                    selected=unit;
                    break;
                }
            }
        }

        //Wait for remind by user
        System.out.print("Press "+ANSI_YELLOW+"Enter"+ANSI_RESET+" to continue");
        Scanner scanner= new Scanner(System.in);
        scanner.nextLine();

        //Display correct answer
        System.out.println("--------------------------------------------------");
        System.out.println("id="+selected.getId());
        System.out.println("q="+selected.getQuestion());
        System.out.println("a="+ANSI_GREEN+selected.getAnswer()+ANSI_RESET);
        if(selected.isVerbIrregular)
        {
            System.out.println(ANSI_GREEN+selected.getAnswer1()+"\t\t"+selected.getAnswer4()+ANSI_RESET);
            System.out.println(ANSI_GREEN+selected.getAnswer2()+"\t\t"+selected.getAnswer5()+ANSI_RESET);
            System.out.println(ANSI_GREEN+selected.getAnswer3()+"\t\t"+selected.getAnswer6()+ANSI_RESET);
        }
        System.out.println("--------------------------------------------------");

        //Assess the quality of repetition response in 0-5 grade scale
        //displayGradeScale();

        //Input grade
        System.out.print("Enter your grade: 0 - 5: ");
        int grade=scanner.nextInt();

        //Calculate and set new grade and next repetition date
        setNextRepDate(selected, grade);

    }

    //Option 1 and 2 menu of quality of repetition response in 0-5 grade scale
    void displayGradeScale() {
        System.out.println("5 - prefect response");
        System.out.println("4 - correct response after a hesitation");
        System.out.println("3 - correct response recalled with serious difficulty");
        System.out.println("2 - incorrect response; where the correct one seemed easy to recall");
        System.out.println("1 - incorrect response; the correct one remembered");
        System.out.println("0 - complete blackout");
    }


    //Calculate and set new grade and next repetition date
    void setNextRepDate(Unit selected, int grade) {

        double newEF=1.3;  //the smallest value
        int newInterval=1; //the smallest value

        //Current Date
        Calendar newDate=new GregorianCalendar();

        if (grade<3) {
            newEF=selected.getEasinessFactor();
        } else
        {
            // For grades 3,4,5,6
            //EF':=EF+(0.1-(5-q)*(0.08+(5-q)*0.02))
            //q=quality of response = grade
            newEF= selected.easinessFactor +
                    (0.1-(5-grade)*(0.08+(5-grade)*0.02));

            //If EF is less than 1.3 then let EF be 1.3.
            if (newEF<1.3) newEF=1.3;


            //if interval > 2 then: for n>2: I(n):=I(n-1)*EF
            if (selected.getInterval()>2) {
                newInterval=(int)(selected.getInterval()*newEF+0.5);
            }

            if (selected.getInterval()==2) {
                newInterval=6;
            }

            if (selected.getInterval()==1) {
                newInterval=2;
            }

        }

        //Set new date + newInterval
        newDate.add(Calendar.DAY_OF_MONTH,newInterval);


        //Set new interval and EF
        selected.setInterval(newInterval);
        selected.setEasinessFactor(newEF);
        selected.setRepetitionDate(newDate);

        //Just for Debug reason
        //selected.displayUnit();

    }
}
