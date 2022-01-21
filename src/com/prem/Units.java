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
    private static final int UNITS_TO_LEARN = 5;

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

//        Unit    unit1 = new Unit(1, true, true, "ESP-robić", "", "",
//                "hacer", "hago", "haces", "hace", "hacemos", "hacéis", "hacen",
//                11, rep_date, 2.8);
//        unitList.add(unit1);
//
//        Unit    unit2 = new Unit(2, true, false, "dwa", "dwa_1", "",
//                "two", "", "", "", "", "", "",
//                11, rep_date, 2.8);
//        unitList.add(unit2);
//
//        rep_date = new GregorianCalendar(2021,Calendar.DECEMBER,27);
//
//        Unit    unit3 = new Unit(3, true, false, "trzy", "trzy_1", "trzy_2",
//                "three", "", "", "", "", "", "",
//                11, rep_date, 2.8);
//        unitList.add(unit3);
//
//        rep_date = new GregorianCalendar(2022,Calendar.MARCH,1);
//
//        Unit    unit4 = new Unit(4, true, false, "cztery", "", "",
//                "four", "", "", "", "", "", "",
//                1, rep_date, 2.3);
//        unitList.add(unit4);
//
//        Unit    unit5 = new Unit(5, true, false, "pięć", "", "",
//                "five", "", "", "", "", "", "",
//                1, rep_date, 2.3);
//        unitList.add(unit5);
//
//        Unit    unit6 = new Unit(6, true, false, "sześć", "", "",
//                "six", "", "", "", "", "", "",
//                1, rep_date, 1.3);
//        unitList.add(unit6);
//
//        Unit    unit7 = new Unit(7, true, false, "siedem", "", "",
//                "seven", "", "", "", "", "", "",
//                1, rep_date, 1.3);
//        unitList.add(unit7);
//
//        Unit    unit8 = new Unit(8, true, false, "osiem", "", "",
//                "eight", "", "", "", "", "", "",
//                1, rep_date, 1.3);
//        unitList.add(unit8);
//
//        Unit    unit9 = new Unit(9, true,  false, "dziewięć", "", "",
//                "nine", "", "", "", "", "", "",
//                1, rep_date, 1.3);
//        unitList.add(unit9);
//
//        Unit    unit10 = new Unit(10, false, false, "dziesięć", "", "",
//                "ten", "", "", "", "", "", "",
//                1, null, 1.3);
//        unitList.add(unit10);
//
//        Unit    unit11 = new Unit(11, true, false, "jedenaście", "", "",
//                "eleven", "", "", "", "", "", "",
//                1, rep_date, 1.3);
//        unitList.add(unit11);

//        Unit    unit1 = new Unit(1,false,true,"brać (też w znaczeniu pić, jeść)","","","tomar","tomo","tomas","toma","tomamos","tomáis","toman",1,null,1.3); unitList.add(unit1);
//        Unit    unit2 = new Unit(2,false,false,"wino","Nie pijam wina","","el vino","No bebo vino","","","","","",1,null,1.3); unitList.add(unit2);
//        Unit    unit3 = new Unit(3,false,false,"jeden","","","uno","","","","","","",1,null,1.3); unitList.add(unit3);
//        Unit    unit4 = new Unit(40,false,false,"dwa","","","dos","","","","","","",1,null,1.3); unitList.add(unit4);
//        Unit    unit5 = new Unit(5,false,false,"trzy ","","","tres","","","","","","",1,null,1.3); unitList.add(unit5);
//        Unit    unit6 = new Unit(6,false,false,"cztery","","","cuatro","","","","","","",1,null,1.3); unitList.add(unit6);
//        Unit    unit7 = new Unit(7,false,false,"pięć","","","cinco","","","","","","",1,null,1.3); unitList.add(unit7);
//        Unit    unit8 = new Unit(8,false,false,"sześć","","","seis","","","","","","",1,null,1.3); unitList.add(unit8);
//        Unit    unit9 = new Unit(9,false,false,"siedem","","","siete","","","","","","",1,null,1.3); unitList.add(unit9);
//        Unit    unit10 = new Unit(10,false,false,"osiem","","","ocho","","","","","","",1,null,1.3); unitList.add(unit10);
//        Unit    unit11 = new Unit(11,false,false,"dziewięć","","","nueve","","","","","","",1,null,1.3); unitList.add(unit11);
//        Unit    unit12 = new Unit(12,false,false,"dziesięć","Mam dziesięć lat","","diez","Tengo diez años","","","","","",1,null,1.3); unitList.add(unit12);
//        Unit    unit13 = new Unit(13,false,false,"jedenaście","","","once","","","","","","",1,null,1.3); unitList.add(unit13);
//        Unit    unit14 = new Unit(14,false,false,"dwanaście","","","doce","","","","","","",1,null,1.3); unitList.add(unit14);
//        Unit    unit15 = new Unit(15,false,false,"trzynaście","","","trece","","","","","","",1,null,1.3); unitList.add(unit15);
//        Unit    unit16 = new Unit(16,false,false,"czternaście","","","catorce","","","","","","",1,null,1.3); unitList.add(unit16);
//        Unit    unit17 = new Unit(17,false,false,"piętnaście","","","quince","","","","","","",1,null,1.3); unitList.add(unit17);
//        Unit    unit18 = new Unit(18,false,false,"szesnaście","","","dieciséis","","","","","","",1,null,1.3); unitList.add(unit18);
//        Unit    unit19 = new Unit(19,false,false,"siedemnaście","Mam siedemnaście lat","","diecisiete","Tengo diecisiete años","","","","","",1,null,1.3); unitList.add(unit19);
//        Unit    unit20 = new Unit(20,false,false,"osiemnaście","","","dieciocho","","","","","","",1,null,1.3); unitList.add(unit20);
//        Unit    unit21 = new Unit(21,false,false,"dziewiętnaście","","","diecinueve","","","","","","",1,null,1.3); unitList.add(unit21);
//        Unit    unit22 = new Unit(22,false,false,"dwadzieścia","On ma dwadzieścia lat","","veinte","Él tiene veinte años","","","","","",1,null,1.3); unitList.add(unit22);
//        Unit    unit23 = new Unit(23,false,false,"dwadzieścia jeden","Ona ma dwadzieścia jeden lat","","veintiuno","Ella tiene veintiun años","","","","","",1,null,1.3); unitList.add(unit23);
//        Unit    unit24 = new Unit(24,false,false,"dwadzieścia dwa","Mam dwadzieścia dwa lata","","veintidós","Tengo veintidós años","","","","","",1,null,1.3); unitList.add(unit24);
//        Unit    unit25 = new Unit(25,false,false,"dwadzieścia trzy ","On ma dwadzieścia trzy lata a ona dwadzieścia jeden","","veintitrés ","Él tiene veintitrés años y ella veintiuno","","","","","",1,null,1.3); unitList.add(unit25);
//        Unit    unit26 = new Unit(26,false,false,"Pan/Pani","Czy Pan jest Polakiem?","","usted","¿Es usted Polaco?","","","","","",1,null,1.3); unitList.add(unit26);
//        Unit    unit27 = new Unit(27,false,false,"być","ja jestem","ty jesteś, on jest","ser","yo soy","tú eres","él/ella es","","","",1,null,1.3); unitList.add(unit27);
//        Unit    unit28 = new Unit(28,false,false,"Polak","Polka","(Ja) jestem Polakiem","el polaco","la polaca","(Yo) soy polaco","","","","",1,null,1.3); unitList.add(unit28);
//        Unit    unit29 = new Unit(29,false,false,"ja","(ja) Jestem Paweł","","yo","(Yo) soy Pablo","","","","","",1,null,1.3); unitList.add(unit29);
//        Unit    unit30 = new Unit(30,false,false,"ona","Ona jest Polką","","ella","Ella es polaca","","","","","",1,null,1.3); unitList.add(unit30);
//        Unit    unit31 = new Unit(31,false,false,"on","On jest Hiszpanem","","él","Él es español","","","","","",1,null,1.3); unitList.add(unit31);
//        Unit    unit32 = new Unit(32,false,false,"Hiszpan","Hiszpanka","(Ty) jesteś Hiszpanką","el español","la española","(Tú) eres española","","","","",1,null,1.3); unitList.add(unit32);
//        Unit    unit33 = new Unit(33,false,false,"ty","(Ty) jesteś Agnieszka","","tú","(Tú) eres Inés","","","","","",1,null,1.3); unitList.add(unit33);
//        Unit    unit34 = new Unit(34,false,false,"kto?","Kim jesteś?","","¿quién?","¿?Quién eres?","","","","","",1,null,1.3); unitList.add(unit34);
//        Unit    unit35 = new Unit(35,false,false,"Cześć!","","","¡Hola!","","","","","","",1,null,1.3); unitList.add(unit35);
//        Unit    unit36 = new Unit(36,false,false,"jak?","Jak się masz?","","¿cómo?","¿Cómo estás?","","","","","",1,null,1.3); unitList.add(unit36);
//        Unit    unit37 = new Unit(37,false,false,"Ja bawie się","ty bawisz się","on/ona bawi się","yo toco","tú tocas","él/ella usted toca","","","","",1,null,1.3); unitList.add(unit37);
//        Unit    unit38 = new Unit(38,false,false,"Ja jem","Ty jesz","on/ona je","yo como","tú comes","él/ella come","","","","",1,null,1.3); unitList.add(unit38);
//        Unit    unit39 = new Unit(39,false,false,"dobrze","w porządku","Masz się dobrze?","bien","bien","¿Estás bien?","","","","",1,null,1.3); unitList.add(unit39);
//        Unit    unit40 = new Unit(40,false,false,"tak","Tak, mam się dobrze","","sí","Sí, estoy bien","","","","","",1,null,1.3); unitList.add(unit40);
//        Unit    unit41 = new Unit(41,false,false,"nie ","Nie, nie mam się dobrze","","no","No, no estoy bien","","","","","",1,null,1.3); unitList.add(unit41);
//        Unit    unit42 = new Unit(42,false,false,"Dziękuje","Mam się dobrze, dziękuje","","¡Gracias!","Estoy bien, gracias","","","","","",1,null,1.3); unitList.add(unit42);
//        Unit    unit43 = new Unit(43,false,false,"bardzo","Paweł ma się bardzo dobrze","","muy","Pablo está muy bien","","","","","",1,null,1.3); unitList.add(unit43);
//        Unit    unit44 = new Unit(44,false,false,"i; a","A jak się ma Paweł","","y","¿Y cómo está Pablo?","","","","","",1,null,1.3); unitList.add(unit44);
//        Unit    unit45 = new Unit(45,false,false,"gdzie?","","","¿dónde?","","","","","","",1,null,1.3); unitList.add(unit45);
//        Unit    unit46 = new Unit(46,false,false,"z","Skąd jesteś?","","de","¿De dónde eres?","","","","","",1,null,1.3); unitList.add(unit46);
//        Unit    unit47 = new Unit(47,false,false,"Polska","Jestem z Polski","","Polonia","Soy de Polonia","","","","","",1,null,1.3); unitList.add(unit47);
//        Unit    unit48 = new Unit(48,false,false,"Warszawa","Jesteś z Warszawy?","Nie, nie jestem z Warszawy","Varsovia","¿Eres de Varsovia?","No, no soy de Varsovia","","","","",1,null,1.3); unitList.add(unit48);
//        Unit    unit49 = new Unit(49,false,false,"w","Gdzie jesteś?","Jestem w Polsce","en","¿Dónde estás?","Estoy en Polonia","","","","",1,null,1.3); unitList.add(unit49);
//        Unit    unit50 = new Unit(50,false,false,"my (mężczyzni)","(My) jesteśmy w Polsce","","nosotros","(Nosotros) estamos en Polonia","","","","","",1,null,1.3); unitList.add(unit50);
//        Unit    unit51 = new Unit(51,false,false,"być (pochodzenie)","my jesteśmy","wy jesteście, oni są","ser","somos","sois, son","","","","",1,null,1.3); unitList.add(unit51);
//        Unit    unit52 = new Unit(52,false,false,"być (stanu emocjonalnego)","my jesteśmy","wy jesteście, oni są","estar","estamos","estáis, están","","","","",1,null,1.3); unitList.add(unit52);
//        Unit    unit53 = new Unit(53,false,false,"my (kobiety)","(My) jesteśmy z Polski","","nosotras","(Nosotras) somos de Polonia","","","","","",1,null,1.3); unitList.add(unit53);
//        Unit    unit54 = new Unit(54,false,false,"wy (mężczyźni)","Czy (wy) jesteście w Hiszpanii?","","vosotros","¿Estáis (vosotros) en España?","","","","","",1,null,1.3); unitList.add(unit54);
//        Unit    unit55 = new Unit(55,false,false,"oni","Czy oni są w Madrycie?","Tak, oni są w Madrycie","ellos","¿Están (ellos) en Madrid?","Sí, (ellos) están en Madrid","","","","",1,null,1.3); unitList.add(unit55);
//        Unit    unit56 = new Unit(56,false,false,"państwo","Czy państwo są z Warszawy?","","ustedes ","¿Son ustedes de Varsovia?","","","","","",1,null,1.3); unitList.add(unit56);
//        Unit    unit57 = new Unit(57,false,false,"Jak się masz?","","","¿Cómo estás?","","","","","","",1,null,1.3); unitList.add(unit57);
//        Unit    unit58 = new Unit(58,false,false,"skąd jesteś?","","","¿De dónde eres?","","","","","","",1,null,1.3); unitList.add(unit58);
//        Unit    unit59 = new Unit(59,false,false,"Mówisz po hiszpańsku?","","","¿Hablas español?","","","","","","",1,null,1.3); unitList.add(unit59);
//        Unit    unit60 = new Unit(60,false,false,"Ile masz lat?","","","¿Cuántos años tienes?","","","","","","",1,null,1.3); unitList.add(unit60);
//        Unit    unit61 = new Unit(61,false,false,"Hiszpania","Czy Piotr jest w Hiszpani?","Tak, Piotr jest w Hiszpanii","España","¿Está Pedro en España?","Sí, Pedro está en España","","","","",1,null,1.3); unitList.add(unit61);
//        Unit    unit62 = new Unit(62,false,false,"Madryt","Czy Pan jest z Madrytu?","","Madrit","¿Es usted de Madrid?","","","","","",1,null,1.3); unitList.add(unit62);
//        Unit    unit63 = new Unit(63,false,false,"wy (kobiety)","Czy (wy) jesteście z Hiszpanii?","","vosotras","¿Sois (vosotras) de España?","","","","","",1,null,1.3); unitList.add(unit63);
//        Unit    unit64 = new Unit(64,false,false,"one ","Czy one są z Madrytu?","Nie, one nie są z Madrytu","ellas","¿Son (ellas) de Madrid?","No, (ellas) no son de Madrid","","","","",1,null,1.3); unitList.add(unit64);
//        Unit    unit65 = new Unit(65,false,false,"język włoski","Mówicie po własku?","Nie, nie mówimy po włosku","el italiano","¿Habláis italiano","No, no hablamos italiano","","","","",1,null,1.3); unitList.add(unit65);
//        Unit    unit66 = new Unit(66,false,false,"język francuski","Mówi pan po francusku?","Tak, mówie po francusku ","el francés","¿Habla usted francés?","Sí, heblo francés","","","","",1,null,1.3); unitList.add(unit66);
//        Unit    unit67 = new Unit(67,false,false,"język niemiecki","Mówię dobrze po niemiecku","","el alemán","Hablo bien alemán","","","","","",1,null,1.3); unitList.add(unit67);
//        Unit    unit68 = new Unit(68,false,false,"język angielski","Mówisz po angielsku?","Tak, mówie po angielsku","el inglés","¿Hablas inglés?","Sí, hablo inglés","","","","",1,null,1.3); unitList.add(unit68);
//        Unit    unit69 = new Unit(69,false,true,"mówić","","","hablar","hablo","hablas","habla","hablamos","hablais","hablan",1,null,1.3); unitList.add(unit69);
//        Unit    unit70 = new Unit(70,false,false,"wszystko","Rozumiem wszystko","","todo","Entiendo todo","","","","","",1,null,1.3); unitList.add(unit70);
//        Unit    unit71 = new Unit(71,false,false,"język rosyjski","Oni mówią dobrze po rosyjsku","","el ruso","Ellos hablan bien ruso","","","","","",1,null,1.3); unitList.add(unit71);
//        Unit    unit72 = new Unit(72,false,false,"nazywać się ","ja/ty nazywam się","on/ona nazywa sie","Ilamarse","me Ilamo/te Ilamas","se Ilama","","","","",1,null,1.3); unitList.add(unit72);
//        Unit    unit73 = new Unit(73,false,false,"Anglia","Jestem z Anglii","","Inglaterra","Soy de Inglaterra","","","","","",1,null,1.3); unitList.add(unit73);
//        Unit    unit74 = new Unit(74,false,false,"Rosja","Jestem z Rosji","","Rusia","Soy de Rusia","","","","","",1,null,1.3); unitList.add(unit74);



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

        boolean isContinue=false;

        if (!isRepetitionDone) {
            System.out.print(ANSI_RED + "Repetitions have not been done. " + ANSI_RESET);
            System.out.print("Would you like to continue Y/N? ");

            Scanner scanner = new Scanner(System.in);
            String tmpAnswer = scanner.nextLine();

            if (tmpAnswer.equals("Y") || (tmpAnswer.equals("y"))) {

                //Continue without repetitions
                isContinue = true;
            }
        }
        else {
            isContinue=true;
        }

        if (isContinue) {

            int[] indexes = new int[UNITS_TO_LEARN];
            int[] repetitions = new int[UNITS_TO_LEARN];

            //Set repetitions number to 0
            for (int y=0;y<UNITS_TO_LEARN;y++)
                repetitions[y]=0;

            //Remember indexes of units to learn
            int i=0;
            for (Unit unit: unitList) {
//              System.out.println("id "+unit.getId());
                if (!unit.isTaught())
                {
                    //Remember unit's index
//                    System.out.println("remembered id "+unit.getId());
                    indexes[i]=unitList.indexOf(unit);
                    i++;

                    // if UNITS_TO_LEARN is reached -  break the loop
                    if (i>=UNITS_TO_LEARN){
                        break;
                    }
                }
            }

            //Debug
//            for (int y=0;y<UNITS_TO_LEARN;y++) {
//                System.out.println("repetitions[" + y + "]=" + repetitions[y]);
//                System.out.println("indexes[" + y + "]=" + indexes[y]);
//            }

            //Set LEFT_TO_LEARN to UNITS_TO_LEARN.
            //Number of new units left to learn - daily
            //initial value is UNITS_TO_LEARN
            int LEFT_TO_LEARN = i;
            int REAL_UNITS_TO_LEARN=i;

            //Debug
//            System.out.println("LEFT_TO_LEARN="+LEFT_TO_LEARN);

            if (LEFT_TO_LEARN==0)
                System.out.println(ANSI_YELLOW+"There is no unit to learn!!!"+ANSI_RESET);

            while(LEFT_TO_LEARN >0){

                //Draw a number from 1 to LEFT_TO_LEARN
                Random randomNumber = new Random();

                //Number from 0 to REAL_UNITS_TO_LEARN-1
                int random = randomNumber.nextInt(REAL_UNITS_TO_LEARN);

                System.out.println("random="+random);
                System.out.println("repetitions[random]="+repetitions[random]);
                System.out.println("LEFT_TO_LEARN="+LEFT_TO_LEARN);

                //if correct repetition is lower than REP_TO_LEARN
                if (repetitions[random]<REP_TO_LEARN) {
                    //Display question
                    Unit unit=unitList.get(indexes[random]);
                    unit.displayQuestion();


                    //Wait for answer (in memory) by user
                    System.out.print("Press "+ANSI_YELLOW+"Enter"+ANSI_RESET+" to continue");
                    Scanner scanner = new Scanner(System.in);
                    scanner= new Scanner(System.in);
                    scanner.nextLine();

                    //Display answer
                    unit.displayAnswer();

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

                            //Calculate and set new grade and next repetition date
                            setNextRepDate(unit, grade);

                            //Debug
//                            System.out.println("id="+unit.getId()+" learnt");
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

        //Set total units number
        totalUnitNumber=totalUnits();
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
