package com.prem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Units {
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String DATA_FILE_ENG_NAME="data_eng.txt";
    public static final String DATA_FILE_ESP_NAME="data_esp.txt";

    private final
    List<Unit> unitList = new ArrayList<>();
    int unitsToRepeat=0;
    int totalUnitNumber=0;
    int unitNumberToLearn=0;
    String dataFileName="";

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

        //Set total units number
        totalUnitNumber=totalUnits();
    }

    //Used in constructor to load data from DB
    boolean loadFromDB() throws ParseException {
        //  Load all unit from DateBase

        //Test data preparation
        Calendar rep_date = new GregorianCalendar(2021,Calendar.DECEMBER,28);

        Unit    unit1 = new Unit(1, true, true, "ESP-robić", "", "",
                "hacer", "hago", "haces", "hace", "hacemos", "hacéis", "hacen",
                11, rep_date, 2.8);
        unitList.add(unit1);

        Unit    unit2 = new Unit(2, true, false, "dwa", "dwa_1", "",
                "two", "", "", "", "", "", "",
                11, rep_date, 2.8);
        unitList.add(unit2);

        rep_date = new GregorianCalendar(2021,Calendar.DECEMBER,27);

        Unit    unit3 = new Unit(3, true, false, "trzy", "trzy_1", "trzy_2",
                "three", "", "", "", "", "", "",
                11, rep_date, 2.8);
        unitList.add(unit3);

        rep_date = new GregorianCalendar(2022,Calendar.MARCH,1);

        Unit    unit4 = new Unit(4, true, false, "cztery", "", "",
                "four", "", "", "", "", "", "",
                1, rep_date, 2.3);
        unitList.add(unit4);

        Unit    unit5 = new Unit(5, true, false, "pięć", "", "",
                "five", "", "", "", "", "", "",
                1, rep_date, 2.3);
        unitList.add(unit5);

        Unit    unit6 = new Unit(6, true, false, "sześć", "", "",
                "six", "", "", "", "", "", "",
                1, rep_date, 1.3);
        unitList.add(unit6);

        Unit    unit7 = new Unit(7, true, false, "siedem", "", "",
                "seven", "", "", "", "", "", "",
                1, rep_date, 1.3);
        unitList.add(unit7);

        Unit    unit8 = new Unit(8, true, false, "osiem", "", "",
                "eight", "", "", "", "", "", "",
                1, rep_date, 1.3);
        unitList.add(unit8);

        Unit    unit9 = new Unit(9, true,  false, "dziewięć", "", "",
                "nine", "", "", "", "", "", "",
                1, rep_date, 1.3);
        unitList.add(unit9);

        Unit    unit10 = new Unit(10, true, false, "dziesięć", "", "",
                "10", "", "", "", "", "", "",
                1, rep_date, 1.3);
        unitList.add(unit10);

        Unit    unit11 = new Unit(11, false, false, "jedenaście", "", "",
                "eleven", "", "", "", "", "", "",
                1, null, 1.3);
        unitList.add(unit11);

        Scanner scanner= new Scanner(System.in);
        int option=0;
        System.out.println("Choose the langage? 1-ENG, 2-ESP");

        do {
            option=(int)scanner.nextInt();
        } while ((option!=1) && (option!=2));

        if (option==1) dataFileName=DATA_FILE_ENG_NAME;
        if (option==2) dataFileName=DATA_FILE_ESP_NAME;

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

    //Option 2 - Count the number of all units
    int totalUnits() {

        int tU = unitList.size();
        System.out.println("Total units:"+tU);
        return tU;
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

    //Option 2
    void Learn(){

        //Test DB Connection
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "przemek", "przemek");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Option x and 9
    //Rightnow data will be store in text file
    void saveDateToDB() {

        String line = "";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(dataFileName));

            //Number of units
            line= String.valueOf(totalUnitNumber);
            writer.write(line);
            writer.newLine();
            line="--------------------------------------------------";
            writer.write(line);
            writer.newLine();

            //Save all units
            for (Unit unit: unitList) {
                //Id
                line=String.valueOf(unit.getId());
                writer.write(line);
                writer.newLine();

                //isTaught
                line=String.valueOf(unit.isTaught());
                writer.write(line);
                writer.newLine();

                //isVerbIrregular
                line=String.valueOf(unit.isVerbIrregular());
                writer.write(line);
                writer.newLine();

                //question
                line=unit.getQuestion();
                writer.write(line);
                writer.newLine();

                //question1
                line=unit.getQuestion1();
                writer.write(line);
                writer.newLine();

                //question2
                line=unit.getQuestion2();
                writer.write(line);
                writer.newLine();

                //answer
                line=unit.getAnswer();
                writer.write(line);
                writer.newLine();

                //answer1
                line=unit.getAnswer1();
                writer.write(line);
                writer.newLine();

                //answer2
                line=unit.getAnswer2();
                writer.write(line);
                writer.newLine();

                //answer3
                line=unit.getAnswer3();
                writer.write(line);
                writer.newLine();

                //answer4
                line=unit.getAnswer4();
                writer.write(line);
                writer.newLine();

                //answer5
                line=unit.getAnswer5();
                writer.write(line);
                writer.newLine();

                //answer6
                line=unit.getAnswer6();
                writer.write(line);
                writer.newLine();

                //interval
                line=String.valueOf(unit.getInterval());
                writer.write(line);
                writer.newLine();

                if(unit.isTaught()) {
                    //repetitionDate
                    GregorianCalendar calendar = new GregorianCalendar();
                    String month="";
                    String day="";
                    calendar=(GregorianCalendar) unit.getRepetitionDate();

                    if (calendar.get(Calendar.MONTH)<10)
                        month="0"+String.valueOf(calendar.get(Calendar.MONTH));
                    else
                        month=String.valueOf(calendar.get(Calendar.MONTH));

                    if (calendar.get(Calendar.DAY_OF_MONTH)<10)
                        day="0"+String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
                    else
                        day=String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

                    line=String.valueOf(calendar.get(Calendar.YEAR))+"-"+
                            month+"-"+
                            day;
                }
                else
                    line="";

                writer.write(line);
                writer.newLine();

                //easinessFactor
                line=String.valueOf(unit.getEasinessFactor());
                writer.write(line);
                writer.newLine();

                //separator
                line="--------------------------------------------------";
                writer.write(line);
                writer.newLine();
            }
            writer.close();

            System.out.println("Data correctly saved in DB");

        } catch (IOException e) {
            System.out.println("Data NOT correctly saved in DB");
            e.printStackTrace();
        }


    }

    //Option 9 - Exit & Save date to File
    void Exit() {
        saveDateToDB();
    }
}
