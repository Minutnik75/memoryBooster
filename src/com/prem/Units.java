package com.prem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;

public class Units {
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    public static final String ANSI_PURPLE = "\u001B[35m";
//    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static final String DATA_FILE_ENG_NAME="data_eng.txt";
    public static final String DATA_FILE_ESP_NAME="data_esp.txt";

    private final List<Unit> unitList = new ArrayList<>();
    private int totalUnitNumber=0;
    private int unitNumberToLearn=0;
    private String dataFileName="";
    private boolean isDataSaved=false;      //determine whether data has been saved or not

    private boolean isRepetitionDone=false; //determine whether repetition has been dane or not

    //Number of new units to learn - daily
    private static final int UNITS_TO_LEARN = 3;

    //How many time does unit needs to be repeated to be treated as learnt
    private static final int REP_TO_LEARN=3;


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

        Unit    unit10 = new Unit(10, false, false, "dziesięć", "", "",
                "ten", "", "", "", "", "", "",
                1, null, 1.3);
        unitList.add(unit10);

        Unit    unit11 = new Unit(11, true, false, "jedenaście", "", "",
                "eleven", "", "", "", "", "", "",
                1, rep_date, 1.3);
        unitList.add(unit11);

        Scanner scanner= new Scanner(System.in);
        int option=0;
        System.out.print("Choose the langage? 1-ENG, 2-ESP ");

        do {
            option=scanner.nextInt();
        } while ((option!=1) && (option!=2));

        if (option==1) dataFileName=DATA_FILE_ENG_NAME;
        if (option==2) dataFileName=DATA_FILE_ESP_NAME;

        return true;
    }

    //Option 0 - display all units
    void displayUnits() {
        System.out.println("DisplayBegin");
        for (Unit unit: unitList){
            unit.displayUnit();
        }
        System.out.println("DisplayFinish");
    }

    //Option 1 - repeat units
    void repeatUnits() {
        //Set the number of units to repeat
        int unitsToRepeat = unitsToRepeat();
        System.out.println("Number units to repeat:"+ ANSI_PURPLE + unitsToRepeat + ANSI_RESET);

        //Random unit to repeat
        while (unitsToRepeat >0){
            int selected = (int)(Math.random() * unitsToRepeat)+1;
            //System.out.println("Selected: " + selected);
            displayUnit(selected);
            unitsToRepeat = unitsToRepeat -1;
        }

        isRepetitionDone=true;

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
                    unit.displayQuestion();
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
        selected.displayAnswer();

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

//        //Test DB Connection
//        try {
//
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "przemek", "przemek");
//            Statement statement = connection.createStatement();
//
//            ResultSet resultSet = statement.executeQuery("select * from users");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("username"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        if (!isRepetitionDone)
        {
            System.out.print(ANSI_RED+"Repetitions have not been done. "+ANSI_RESET);
            System.out.print("Would you like to continue Y/N? ");

            Scanner scanner= new Scanner(System.in);
            String tmpAnswer= scanner.nextLine();

            if (tmpAnswer.equals("Y") || (tmpAnswer.equals("y")))
            {
                //Continue without repetitions
                int[] indexes = new int[UNITS_TO_LEARN];
                int[] repetitions = new int[UNITS_TO_LEARN];

                //Set repetitions number to 0
                for (int y=0;y<UNITS_TO_LEARN;y++)
                    repetitions[y]=0;

                //Remember indexes of units to learn
                int i=0;
                for (Unit unit: unitList) {
//            System.out.println("id "+unit.getId());
                    if (!unit.isTaught())
                    {
                        //Remember unit's index
//                System.out.println("remembered id "+unit.getId());
                        indexes[i]=unitList.indexOf(unit);
                        i++;

                        // if UNITS_TO_LEARN is reached break the loop
                        if (i>=UNITS_TO_LEARN){
                            break;
                        }
                    }
                }

                //Set LEFT_TO_LEARN to UNITS_TO_LEARN.
                //Number of new units left to learn - daily
                //initial value is UNITS_TO_LEARN
                int LEFT_TO_LEARN = i;

                if (LEFT_TO_LEARN==0)
                    System.out.println(ANSI_YELLOW+"There is no unit to learn!!!"+ANSI_RESET);

                while(LEFT_TO_LEARN >0){

                    //Draw a number from 1 to LEFT_TO_LEARN
                    Random randomNumber = new Random();

                    //Number from 0 to LEFT_TO_LEARN-1
                    int random = randomNumber.nextInt(LEFT_TO_LEARN);
//            System.out.println("random="+random);
//            System.out.println("rep[random]="+repetitions[random]);
//            System.out.println("LEFT_TO_LEARN="+LEFT_TO_LEARN);

                    //if correct repetition is lower than REP_TO_LEARN
                    if (repetitions[random]<REP_TO_LEARN)
                    {
                        //Display question
                        Unit unit=unitList.get(indexes[random]);
                        unit.displayQuestion();

                        //Display answer
                        //Wait for remind by user
                        System.out.print("Press "+ANSI_YELLOW+"Enter"+ANSI_RESET+" to continue");
                        scanner= new Scanner(System.in);
                        scanner.nextLine();

                        //Evaluate answer
                        //Input grade
                        System.out.print("Enter your grade: 0 - 5: ");
                        int grade=scanner.nextInt();

                        //Grade higher than 3 means correct
                        if (grade>3)
                        {
                            //Increase repetition number
                            repetitions[random]=repetitions[random]+1;

//                    System.out.println("rep[random]="+repetitions[random]);
//                    System.out.println("REP_TO_LEARN="+REP_TO_LEARN);
                            if (repetitions[random]>=REP_TO_LEARN)
                            {
                                //Decrease number to left
                                LEFT_TO_LEARN--;

                                //Mark as Taught
                                unit.setTaught(true);
                            }
                        }

                    }

                }

            }

        }
    }

    //Option 7
    //Right now data will be load from text file
    void loadDataFromDB()
    {
        BufferedReader br = null;
        try {
            br = Files.newBufferedReader(Paths.get(dataFileName));
            int numberOfUnits=0;
            String extractedLine=br.readLine();
            numberOfUnits=Integer.valueOf(extractedLine);
            System.out.println("numberOfUnits: "+extractedLine);

            // =========
            extractedLine=br.readLine();
//            System.out.println("SEP: "+extractedLine);


            for (int i = 0; i < numberOfUnits; i++) {

                //Id
                extractedLine= br.readLine();
//                System.out.println("id: "+extractedLine);
                long id=Long.valueOf(extractedLine);

                //isTaught
                extractedLine= br.readLine();
//                System.out.println("isTaught: "+extractedLine);
                boolean isTaugth=Boolean.valueOf(extractedLine);

                //isVerbIrregular
                extractedLine= br.readLine();
//                System.out.println("isVerbIrregular: "+extractedLine);
                boolean isVerbIrregular=Boolean.valueOf(extractedLine);

                //question
                extractedLine=br.readLine();
                String question=extractedLine;
//                System.out.println("question: "+extractedLine);

                //question1
                extractedLine=br.readLine();
                String question1=extractedLine;
//                System.out.println("question1: "+extractedLine);

                //question2
                extractedLine=br.readLine();
                String question2=extractedLine;
//                System.out.println("question2: "+extractedLine);

                //answer
                extractedLine=br.readLine();
                String answer=extractedLine;
//                System.out.println("answer: "+extractedLine);

                //answer1
                extractedLine=br.readLine();
                String answer1=extractedLine;
//                System.out.println("answer1: "+extractedLine);

                //answer2
                extractedLine=br.readLine();
                String answer2=extractedLine;
//                System.out.println("answer2: "+extractedLine);

                //answer3
                extractedLine=br.readLine();
                String answer3=extractedLine;
//                System.out.println("answer3: "+extractedLine);

                //answer4
                extractedLine=br.readLine();
                String answer4=extractedLine;
//                System.out.println("answer4: "+extractedLine);

                //answer5
                extractedLine=br.readLine();
                String answer5=extractedLine;
//                System.out.println("answer5: "+extractedLine);

                //answer6
                extractedLine=br.readLine();
                String answer6=extractedLine;
//                System.out.println("answer6: "+extractedLine);

                //interval
                extractedLine= br.readLine();
//                System.out.println("interval: "+extractedLine);
                int interval=Integer.valueOf(extractedLine);

                //repetitionDate
                GregorianCalendar repetitionDate = new GregorianCalendar();
                repetitionDate=null;

                extractedLine= br.readLine();
//                System.out.println("repetitionDate: "+extractedLine);

                if(isTaugth) {

                    if(extractedLine.length()>0){
                        String year=extractedLine.substring(0,4);
//                        System.out.println("year: "+year);

                        String month=extractedLine.substring(5,7);
//                        System.out.println("month: "+month);

                        String day=extractedLine.substring(8,10);
//                        System.out.println("day: "+day);

                        int iYear=Integer.valueOf(year);
                        int iMonth=Integer.valueOf(month)-1;
                        int iDay=Integer.valueOf(day);

                        repetitionDate = new GregorianCalendar(iYear,iMonth,iDay);
                    }
                }

                //easinessFactor
                extractedLine= br.readLine();
//                System.out.println("easinessFactor: "+extractedLine);
                double easinessFactor=Double.valueOf(extractedLine);

                //separator
                extractedLine= br.readLine();
//                System.out.println("SEP: "+extractedLine);

                //creates new unit
                Unit unit = new Unit(id,isTaugth,isVerbIrregular,question,question1,question2,answer,answer1,
                        answer2,answer3,answer4,answer5,answer6,interval,repetitionDate,easinessFactor);
                //unit.displayUnit();

                unitList.add(unit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Option 7 - Load data
    void Load() {
        unitList.clear();
        loadDataFromDB();
    }


    //Option 8 and 9
    //Right now data will be store in text file
    void saveDataToDB() {

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


    //Option 8 - Save data to File
    void Save() {
        saveDataToDB();
        isDataSaved=true;
    }

    //Option 9 - Exit & Save data to File
    void Exit() {
        if (!isDataSaved) {
            System.out.print(ANSI_RED+"Data has not been saved. "+ANSI_RESET);
            System.out.print("Would you like to save them Y/N? ");

            Scanner scanner= new Scanner(System.in);
            String tmpAnswer= scanner.nextLine();

            if (!tmpAnswer.equals("N") && (!tmpAnswer.equals("n")))
                saveDataToDB();
        }

    }

}
